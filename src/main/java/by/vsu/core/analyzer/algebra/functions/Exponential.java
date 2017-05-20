package by.vsu.core.analyzer.algebra.functions;

public class Exponential extends MathFunction
{
    public Exponential(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(this.isNegative)
            return -Math.exp(this.operation.calculate());
        else
            return Math.exp(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        return 0;
    }
}
