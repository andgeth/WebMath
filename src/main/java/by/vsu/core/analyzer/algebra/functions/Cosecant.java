package by.vsu.core.analyzer.algebra.functions;

public class Cosecant extends MathFunction
{
    public Cosecant(String str)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative) {
            return -(1. / Math.sin(this.operation.calculate()));
        } else {
            return 1. / Math.sin(this.operation.calculate());
        }
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        if(isNegative) {
            return (1. / Math.tan(this.operation.calculate())) * this.calculate() * this.operation.calculateDerivative(nameVariable);
        } else {
            return -(1. / Math.tan(this.operation.calculate())) * this.calculate() * this.operation.calculateDerivative(nameVariable);
        }
    }
}
