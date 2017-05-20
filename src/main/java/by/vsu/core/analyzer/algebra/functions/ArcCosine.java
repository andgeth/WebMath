package by.vsu.core.analyzer.algebra.functions;

public class ArcCosine extends MathFunction
{
    public ArcCosine(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative)
            return -Math.acos(this.operation.calculate());
        else
            return Math.acos(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(isNegative)
            return (1. / Math.sqrt(1 - Math.pow(this.operation.calculate(), 2))) * this.operation.calculateDerivative(nameVariable);
        else
            return -(1. / Math.sqrt(1 - Math.pow(this.operation.calculate(), 2))) * this.operation.calculateDerivative(nameVariable);
    }
}
