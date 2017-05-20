package by.vsu.core.analyzer.algebra.functions;

public class ArcCotangent extends MathFunction {

    ArcCotangent(String str) {
        super(str);
    }

    @Override
    public double calculate() {
        if (isNegative) {
            return -Math.atan(1. / this.operation.calculate());
        } else {
            return Math.atan(1. / this.operation.calculate());
        }
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        if (isNegative) {
            return 1. / (1 + Math.pow(this.operation.calculate(), 2)) * this.operation.calculateDerivative(nameVariable);
        } else {
            return -1. / (1 + Math.pow(this.operation.calculate(), 2)) * this.operation.calculateDerivative(nameVariable);
        }
    }

}
