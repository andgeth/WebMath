package by.vsu.core.analyzer.algebra.arithmetic;

import by.vsu.core.analyzer.Analyzer;

public class Division extends ArithmeticalOperation {

    Division(String str, int pos) {
        super(str, pos);
        this.operation2 = Analyzer.disassemble(str.substring(pos + 1));
    }

    @Override
    public double calculate() {
        return this.operation1.calculate() / this.operation2.calculate();
    }

    @Override
    public double calculateDerivative(String nameVariable) {
        double val1 = this.operation1.calculate();
        double val2 = this.operation2.calculate();
        double dval1 = this.operation1.calculateDerivative(nameVariable);
        double dval2 = this.operation2.calculateDerivative(nameVariable);
        return (dval1 * val2 - val1 * dval2) / (val2 * val2);
    }

}
