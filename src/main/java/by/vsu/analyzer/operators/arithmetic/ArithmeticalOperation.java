package by.vsu.analyzer.operators.arithmetic;

import by.vsu.analyzer.Analyzer;
import by.vsu.analyzer.operators.Changeable;
import by.vsu.analyzer.operators.MathExpression;
import by.vsu.analyzer.operators.Number;
import by.vsu.analyzer.operators.VariableValuePair;

public abstract class ArithmeticalOperation implements Changeable, MathExpression {

    MathExpression operation1, operation2;

    ArithmeticalOperation(String expr, int pos) {
        this.operation1 = Analyzer.disassemble(expr.substring(0, pos));
        this.operation2 = Analyzer.disassemble(expr.substring(pos + 1));
    }

    public static MathExpression getInstance(char sign, String expr, int pos) {
        switch (sign) {
            case '+':
                return new Plus(expr, pos);
            case '-':
                return new Minus(expr, pos);
            case '*':
                return new Multiplication(expr, pos);
            case '/':
                return new Division(expr, pos);
            case '^':
                return new Power(expr, pos);
            default:
                return null;
        }
    }

    @Override
    public void insertValue(double val) {
        if (this.operation1.getClass() != Number.class) {
            ((Changeable) this.operation1).insertValue(val);
        }
        if (this.operation2.getClass() != Number.class) {
            ((Changeable) this.operation2).insertValue(val);
        }
    }

    @Override
    public void insertValues(VariableValuePair[] vvp) {
        if (this.operation1.getClass() != Number.class) {
            ((Changeable) this.operation1).insertValues(vvp);
        }
        if (this.operation2.getClass() != Number.class) {
            ((Changeable) this.operation2).insertValues(vvp);
        }
    }

    @Override
    public String getDependencies() {
        String s1 = this.operation1.getDependencies();
        String s2 = this.operation2.getDependencies();
        if (!s1.isEmpty() && !s2.isEmpty()) {
            return s1.equals(s2) ? s1 : s1 + ";" + s2;
        } else {
            return s1.isEmpty() ? s2 : s2.isEmpty() ? s1 : "";
        }
    }

}
