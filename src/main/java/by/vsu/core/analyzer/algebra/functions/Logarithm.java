package by.vsu.core.analyzer.algebra.functions;

import by.vsu.core.analyzer.Analyzer;
import by.vsu.core.analyzer.algebra.MathExpression;

public class Logarithm extends MathFunction
{
    private MathExpression base;

    public Logarithm(String str)
    {
        super(str.substring(1, Analyzer.findCommaPosition(str)));
        this.base = Analyzer.disassemble(str.substring(Analyzer.findCommaPosition(str) + 1, str.length() - 1));
    }

    @Override
    public double calculate()
    {
        if(this.isNegative)
            return -(Math.log(this.operation.calculate()) / Math.log(this.base.calculate()));
        else
            return (Math.log(this.operation.calculate()) / Math.log(this.base.calculate()));
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        return 0;
    }

    @Override
    public String getDependencies()
    {
        String s1 = operation.getDependencies();
        String s2 = base.getDependencies();
        if(!s1.isEmpty() && !s2.isEmpty())
            return s1.equals(s2) ? s1 : s1 + ";" + s2;
        else
            return s1.isEmpty() ? s2 : s2.isEmpty() ? s1 : "";
    }
}
