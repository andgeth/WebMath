package by.vsu.analyzer.operators.arithmetic;

import by.vsu.analyzer.Analyzer;

public class Minus extends ArithmeticalOperation {

    Minus(String str, int pos) {
        super(str, pos);
        this.operation2 = Analyzer.disassemble(str.substring(pos));
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
        return this.operation1 + "" + this.operation2;
    }

}
