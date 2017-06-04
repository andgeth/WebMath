package by.vsu.analyzer.operators.functions;

public class HypSecant extends MathFunction
{
    public HypSecant(String str, int pos)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(this.isNegative)
            return -1. / Math.cosh(this.operation.calculate());
        else
            return 1. / Math.cosh(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(this.isNegative)
            return -this.calculate() * Math.tanh(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
        else
            return this.calculate() * Math.tanh(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
    }
}
