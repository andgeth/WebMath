package by.vsu.core.analyzer;

import by.vsu.core.analyzer.algebra.MathExpression;
import by.vsu.core.analyzer.algebra.Number;
import by.vsu.core.analyzer.algebra.Variable;
import by.vsu.core.analyzer.algebra.arithmetic.ArithmeticalOperation;
import by.vsu.core.analyzer.algebra.functions.MathFunction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Analyzer {

    private final static Pattern FUNCTIONS = Pattern.compile("(-?(asin|acos|atg|actg|asec|acsc|sin|cos|ctg|tg|sec|csc|sh|ch|tgh|ctgh|sech|csch|log|ln|lb|root))");

    public static MathExpression disassemble(String str) {
        if (str.charAt(0) == '(' && findCloseBracket(str, 0) == str.length() - 1) {
            str = str.substring(1, str.length() - 1);
        }
        int pos = split(str);
        if (pos != -1) {
            return ArithmeticalOperation.getInstance(str.charAt(pos), str, pos);
        } else {
            int posBracket = str.indexOf('(');
            if (posBracket != -1) {
                String tmp_str = str.substring(0, posBracket);
                if (posBracket == 0 || posBracket == 1 || functionMatches(tmp_str).matches()) {
                    return MathFunction.getInstance(str, posBracket);
                } else {
                    return ArithmeticalOperation.getInstance(str.charAt(posBracket), str, posBracket);
                }
            } else if (str.matches("-?([a-z]+[\\d+]?)") && !str.matches("exp")) {
                return new Variable(str);
            } else {
                return new Number(str);
            }
        }
    }

    public static int findCommaPosition(String str) {
        int br = 0, i = -1;
        do {
            i++;
            if (str.charAt(i) == '(') {
                br++;
            } else if (str.charAt(i) == ')') {
                br--;
            }
        } while (!(str.charAt(i) == ',' && br == 1));
        return i < str.length() ? i : -1;
    }

    public static Matcher functionMatches(String str) {
        return FUNCTIONS.matcher(str);
    }

    public static int findCloseBracket(String str, int position) {
        int countb = 1;
        if (position >= 0) {
            if (str.charAt(position) == '(') {
                position++;
            }
            while (countb > 0) {
                char elem = str.charAt(position);
                if (elem == '(') {
                    countb++;
                }
                if (elem == ')') {
                    countb--;
                }
                if (countb != 0) {
                    position++;
                }
            }
        }
        return position;
    }

    public static int split(String str) {
        int tmpPos = -1;
        int degreePos = -1;
        int i = 1;
        if (str.charAt(0) == '(') {
            i = findCloseBracket(str, i);
        }
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                i = findCloseBracket(str, i);
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-' && (str.charAt(i - 1) != '*' && str.charAt(i - 1) != '/' && str.charAt(i - 1) != '^')) {
                return i;
            }
            if (str.charAt(i) == '*' || str.charAt(i) == '/') {
                tmpPos = i;
            }
            if (str.charAt(i) == '^') {
                degreePos = i;
            }
        }
        return tmpPos == -1 ? degreePos : tmpPos;
    }

}