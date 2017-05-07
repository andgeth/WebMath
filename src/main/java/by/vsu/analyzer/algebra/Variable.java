package main.java.by.vsu.analyzer.algebra;

public class Variable implements MathExpression,
                                 Changeable {
    private String name;
    private double value = Double.NaN;
    private boolean isNegative = false;

    public Variable(String str) {
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            str = str.substring(1, str.length() - 1);
        }
        if (str.charAt(0) == '-') {
            this.isNegative = true;
            this.name = str.substring(1);
        } else {
            this.name = str;
        }
    }

    @Override
    public double calculate() {
        if (!Double.isNaN(this.value)) {
            if (isNegative) {
                return -this.value;
            } else {
                return this.value;
            }
        } else {
            return Double.NaN;
        }
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        if (!Double.isNaN(this.value)) {
            if (isNegative) {
                return this.name.equals(nameVariable) ? -1 : 0;
            } else {
                return this.name.equals(nameVariable) ? 1 : 0;
            }
        } else {
            return Double.NaN;
        }
    }

    @Override
    public void insertValue(double val) {
        this.value = val;
    }

    @Override
    public void insertValues(VariableValuePair[] vvp) {
        for (VariableValuePair i : vvp) {
            if (this.name.equals(i.getNameVariable())) {
                this.value = i.getValue();
            }
        }
    }

    @Override
    public String getDependencies() {
        return name;
    }

    public String toString() {
        return isNegative ? "-" + String.valueOf(this.name) : String.valueOf(this.name);
    }
}
