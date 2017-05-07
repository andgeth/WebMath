package main.java.by.vsu.analyzer.algebra.functions;

public class Tangent extends MathFunction
{
    public Tangent(String str, int pos)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative)
            return -Math.tan(this.operation.calculate());
        else
            return Math.tan(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        double val = Math.cos(this.operation.calculate());
        if(isNegative)
            return -(1. /  (val * val)) * this.operation.calculateDerivative(nameVariable);
        else
            return (1. / (val * val)) * this.operation.calculateDerivative(nameVariable);
    }
}
