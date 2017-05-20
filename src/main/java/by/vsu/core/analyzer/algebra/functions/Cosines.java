package by.vsu.core.analyzer.algebra.functions;

public class Cosines extends MathFunction
{
    public Cosines(String str, int pos)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative)
            return -Math.cos(this.operation.calculate());
        else
            return Math.cos(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(isNegative)
            return Math.sin(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
        else
            return -Math.sin(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
    }
}
