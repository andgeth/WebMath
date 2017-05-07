package main.java.by.vsu.analyzer.algebra.arithmetic;

public class Power extends ArithmeticalOperation {

    Power(String str, int pos) {
        super(str, pos);
    }

    @Override
    public double calculate() {
        return Math.pow(this.operation1.calculate(), this.operation2.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        if (this.operation1.getDependencies().isEmpty()) {
            return this.calculate() * Math.log(this.operation1.calculate()) * this.operation2.calculate();
        } else if (this.operation2.getDependencies().isEmpty()) {
            return this.operation2.calculate() * Math.pow(this.operation1.calculate(), this.operation2.calculate() - 1) * this.operation1.calculateDerivative(nameVariable);
        }
        return Double.NaN;
    }

}
