package by.vsu.analyzer;

import by.vsu.analyzer.operators.Changeable;
import by.vsu.analyzer.operators.MathExpression;
import by.vsu.analyzer.operators.Number;
import by.vsu.analyzer.operators.VariableValuePair;

public class AlgebraicFunction {

    private MathExpression mathExpression;
    private String strView;

    public AlgebraicFunction(String str) {
        this.mathExpression = Analyzer.disassemble(str);
        this.strView = str;
    }

    public String getDependencies() {
        return mathExpression.getDependencies();
    }

    public String getStrView() {
        return strView;
    }

    public double getDerivativeValue(String nameVariable) {
        return this.mathExpression.calculateDerivative(nameVariable);
    }

    public double getValue() {
        return this.mathExpression.calculate();
    }

    public void insertValue(double val) {
        if (this.mathExpression.getClass() != Number.class) {
            ((Changeable) this.mathExpression).insertValue(val);
        }
    }

    public void insertValues(VariableValuePair[] vvp) {
        if (this.mathExpression.getClass() != Number.class) {
            ((Changeable) this.mathExpression).insertValues(vvp);
        }
    }

    public String toString() {
        return mathExpression.toString();
    }

}
