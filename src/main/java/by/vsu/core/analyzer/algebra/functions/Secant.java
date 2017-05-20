package by.vsu.core.analyzer.algebra.functions;

public class Secant extends MathFunction
{
    public Secant(String str, int pos)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative == true)
            return -(1. / Math.cos(this.operation.calculate()));
        else
            return 1. / Math.cos(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(isNegative)
            return -Math.tan(this.operation.calculate()) * this.calculate() * this.operation.calculateDerivative(nameVariable);
        else
            return Math.tan(this.operation.calculate()) * this.calculate() * this.operation.calculateDerivative(nameVariable);
    }
}
