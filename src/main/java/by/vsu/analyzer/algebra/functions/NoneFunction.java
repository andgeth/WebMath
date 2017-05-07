package main.java.by.vsu.analyzer.algebra.functions;

public class NoneFunction extends MathFunction {

    NoneFunction(String str) {
        super(str);
    }

    @Override
    public double calculate() {
        if (isNegative) {
            return -this.operation.calculate();
        } else {
            return this.operation.calculate();
        }
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        if (isNegative) {
            return -this.operation.calculateDerivative(nameVariable);
        } else {
            return this.operation.calculateDerivative(nameVariable);
        }
    }

}
