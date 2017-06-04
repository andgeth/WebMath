package by.vsu.analyzer.operators.functions;

public class ArcSecant extends MathFunction {

    ArcSecant(String str) {
        super(str);
    }

    @Override
    public double calculate() {
        if (this.isNegative) {
            return -Math.acos(1. / this.operation.calculate());
        } else {
            return Math.acos(1. / this.operation.calculate());
        }
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        if (this.isNegative) {
            return -(1. / (this.operation.calculate() * Math.sqrt(Math.pow(this.operation.calculate(), 2) - 1))) * this.operation.calculateDerivative(nameVariable);
        } else {
            return (1. / (this.operation.calculate() * Math.sqrt(Math.pow(this.operation.calculate(), 2) - 1))) * this.operation.calculateDerivative(nameVariable);
        }
    }

}
