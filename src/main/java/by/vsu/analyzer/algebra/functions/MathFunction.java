package main.java.by.vsu.analyzer.algebra.functions;

import main.java.by.vsu.analyzer.Analyzer;
import main.java.by.vsu.analyzer.algebra.Changeable;
import main.java.by.vsu.analyzer.algebra.MathExpression;
import main.java.by.vsu.analyzer.algebra.Number;
import main.java.by.vsu.analyzer.algebra.VariableValuePair;

public abstract class MathFunction implements Changeable,
                                              MathExpression {

    enum Type {
        root, log, sin, cos, tg, ctg, sec, csc, asin, acos, atg, actg, asec, acsc, sh, ch, th, cth, sech, csch, none
    }

    boolean isNegative = false;
    MathExpression operation;

    public MathFunction(String str) {
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            str = str.substring(1, str.length() - 1);
        }
        this.operation = Analyzer.disassemble(str);
        if (str.charAt(0) == '-') {
            this.isNegative = true;
        }
    }

    static public MathExpression getInstance(String content, int pos) {
        MathFunction m;
        String type;
        if (content.charAt(0) == '-') {
            type = content.substring(1, pos);
        } else {
            type = content.substring(0, pos);
        }
        String expr = content.substring(pos);
        if (type.equals("")) {
            m = new NoneFunction(expr);
        } else {
            switch (Type.valueOf(type.toLowerCase())) {
                case root:
                    m = new Root(expr);
                    break;
                case log:
                    m = new Logarithm(expr);
                    break;
                case sin:
                    m = new Sinus(expr, pos);
                    break;
                case cos:
                    m = new Cosines(expr, pos);
                    break;
                case tg:
                    m = new Tangent(expr, pos);
                    break;
                case ctg:
                    m = new Cotangent(expr);
                    break;
                case sec:
                    m = new Secant(expr, pos);
                    break;
                case csc:
                    m = new Cosecant(expr);
                    break;
                case asin:
                    m = new ArcSine(expr);
                    break;
                case acos:
                    m = new ArcCosine(expr);
                    break;
                case atg:
                    m = new ArcTangent(expr);
                    break;
                case actg:
                    m = new ArcCotangent(expr);
                    break;
                case asec:
                    m = new ArcSecant(expr);
                    break;
                case acsc:
                    m = new ArcCosecant(expr);
                    break;
                case sh:
                    m = new HypSine(expr);
                    break;
                case ch:
                    m = new HypCosine(expr);
                    break;
                case th:
                    m = new HypTangent(expr, pos);
                    break;
                case cth:
                    m = new HypCotangent(expr);
                    break;
                case sech:
                    m = new HypSecant(expr, pos);
                    break;
                case csch:
                    m = new HypCosecant(expr, pos);
                    break;
                default:
                    m = null;
            }
        }
        if (content.charAt(0) == '-') {
            m.isNegative = true;
        }
        return m;
    }

    @Override
    public void insertValue(double val) {
        if (this.operation.getClass() != Number.class) {
            ((Changeable) this.operation).insertValue(val);
        }
    }

    @Override
    public void insertValues(VariableValuePair[] vvp) {
        if (this.operation.getClass() != Number.class) {
            ((Changeable) this.operation).insertValues(vvp);
        }
    }

    @Override
    public String getDependencies() {
        return operation.getDependencies();
    }

}
