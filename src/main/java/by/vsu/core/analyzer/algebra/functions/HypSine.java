package by.vsu.core.analyzer.algebra.functions;

public class HypSine extends MathFunction
{
    public HypSine(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if (this.isNegative)
            return -Math.sinh(this.operation.calculate());
        else
            return Math.sinh(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(this.isNegative)
            return -Math.cosh(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
        else
            return Math.cosh(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
    }
}
