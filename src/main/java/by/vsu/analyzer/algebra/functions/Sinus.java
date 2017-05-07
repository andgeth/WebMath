package main.java.by.vsu.analyzer.algebra.functions;

public class Sinus extends MathFunction
{
    public Sinus(String str, int pos)
    {
        super(str);
    }

    @Override
    public double calculate()
    {
        if(isNegative == true)
            return -Math.sin(this.operation.calculate());
        else
            return Math.sin(this.operation.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {

        if(isNegative)
            return -Math.cos(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
        else
            return Math.cos(this.operation.calculate()) * this.operation.calculateDerivative(nameVariable);
    }

    public String toString()
    {
        return "sin("+this.operation+")";
    }
}
