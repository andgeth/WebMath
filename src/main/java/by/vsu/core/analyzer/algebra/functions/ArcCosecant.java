package by.vsu.core.analyzer.algebra.functions;

public class ArcCosecant extends MathFunction {

    ArcCosecant(String str) {
        super(str);
    }

    @Override
    public double calculate() {
        if (this.isNegative) {
            return -Math.asin(1. / this.operation.calculate());
        } else {
            return Math.asin(1. / this.operation.calculate());
        }
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        if (this.isNegative) {
            return (1. / (this.operation.calculate() * Math.sqrt(Math.pow(this.operation.calculate(), 2) - 1))) * this.operation.calculateDerivative(nameVariable);
        } else {
            return -(1. / (this.operation.calculate() * Math.sqrt(Math.pow(this.operation.calculate(), 2) - 1))) * this.operation.calculateDerivative(nameVariable);
        }
    }

}
