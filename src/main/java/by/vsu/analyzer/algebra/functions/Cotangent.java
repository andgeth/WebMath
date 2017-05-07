package main.java.by.vsu.analyzer.algebra.functions;

public class Cotangent extends MathFunction
{
    public Cotangent(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative)
            return -1. / Math.tan(this.operation.calculate());
        else
            return 1. / Math.tan(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(isNegative)
            return (1. / Math.pow(Math.sin(this.operation.calculate()), 2)) * this.operation.calculateDerivative(nameVariable);
        else
            return -(1. / Math.pow(Math.sin(this.operation.calculate()), 2)) * this.operation.calculateDerivative(nameVariable);
    }
}
