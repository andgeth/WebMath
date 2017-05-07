package main.java.by.vsu.analyzer.algebra.functions;

public class ArcSine extends MathFunction
{
    public ArcSine(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative)
            return -Math.asin(this.operation.calculate());
        else
            return Math.asin(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(isNegative)
            return -1. / Math.sqrt(1 - this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
        else
            return 1. / Math.sqrt(1 - this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
    }
}
