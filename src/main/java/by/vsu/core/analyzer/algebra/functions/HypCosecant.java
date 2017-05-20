package by.vsu.core.analyzer.algebra.functions;

public class HypCosecant extends MathFunction
{
    public HypCosecant(String str, int pos)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(this.isNegative)
            return -1. / Math.sinh(this.operation.calculate());
        else
            return 1. / Math.sinh(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(this.isNegative)
            return -this.calculate() * (1. / Math.tanh(this.operation.calculate())) * this.operation.calculateDerivative(nameVariable);
        else
            return this.calculate() * (1. / Math.tanh(this.operation.calculate())) * this.operation.calculateDerivative(nameVariable);

    }
}
