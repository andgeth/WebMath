package by.vsu.analyzer.operators.functions;

public class HypCotangent extends MathFunction
{
    public HypCotangent(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(this.isNegative)
            return -1. / Math.tanh(this.operation.calculate());
        else
            return 1. / Math.tanh(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(this.isNegative)
            return (1. / Math.pow(Math.sinh(this.operation.calculate()), 2)) * this.operation.calculateDerivative(nameVariable);
        else
            return -(1. / Math.pow(Math.sinh(this.operation.calculate()), 2)) * this.operation.calculateDerivative(nameVariable);
    }
}
