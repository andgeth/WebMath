package main.java.by.vsu.analyzer.algebra.arithmetic;

public class Plus extends ArithmeticalOperation {

    Plus(String str, int pos) {
        super(str, pos);
    }

    @Override
    public double calculate() {
        return this.operation1.calculate() + this.operation2.calculate();
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        return this.operation1.calculateDerivative(nameVariable) + this.operation2.calculateDerivative(nameVariable);
    }

    public String toString() {
        return this.operation1.toString() + "+" + this.operation2.toString();
    }

}
