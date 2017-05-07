package main.java.by.vsu.analyzer.algebra.arithmetic;

public class Multiplication extends ArithmeticalOperation {

    Multiplication(String str, int pos) {
        super(str, pos);
    }

    @Override
    public double calculate() {
        return this.operation1.calculate() * this.operation2.calculate();
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        return this.operation1.calculateDerivative(nameVariable) * this.operation2.calculate() + this.operation2.calculateDerivative(nameVariable) * this.operation1.calculate();
    }

}
