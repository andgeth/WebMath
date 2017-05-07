package main.java.by.vsu.analyzer.algebra.functions;

public class ArcTangent extends MathFunction
{
    public ArcTangent(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative)
            return -Math.atan(this.operation.calculate());
        else
            return Math.atan(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(isNegative)
            return -1. / (1 + Math.pow(this.operation.calculate(), 2)) * this.operation.calculateDerivative(nameVariable);
        else
            return 1. / (1 + Math.pow(this.operation.calculate(), 2)) * this.operation.calculateDerivative(nameVariable);
    }
}
