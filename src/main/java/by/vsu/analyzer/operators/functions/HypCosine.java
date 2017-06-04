package by.vsu.analyzer.operators.functions;

public class HypCosine extends MathFunction
{
    public HypCosine(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(this.isNegative)
            return -Math.cosh(this.operation.calculate());
        else
            return Math.cosh(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(this.isNegative)
            return -Math.sinh(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
        else
            return Math.sinh(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
    }
}
