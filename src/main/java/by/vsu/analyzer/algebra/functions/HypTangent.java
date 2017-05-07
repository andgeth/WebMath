package main.java.by.vsu.analyzer.algebra.functions;

public class HypTangent extends MathFunction
{
    public HypTangent(String str, int pos)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(this.isNegative)
            return -Math.tanh(this.operation.calculate());
        else
            return Math.tanh(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(this.isNegative)
            return -(1. / Math.cosh(this.operation.calculate())) * this.operation.calculateDerivative(nameVariable);
        else
            return (1. / Math.cosh(this.operation.calculate())) * this.operation.calculateDerivative(nameVariable);
    }
}
