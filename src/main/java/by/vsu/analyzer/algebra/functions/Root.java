package main.java.by.vsu.analyzer.algebra.functions;

import main.java.by.vsu.analyzer.Analyzer;
import main.java.by.vsu.analyzer.algebra.MathExpression;

public class Root extends MathFunction
{
    MathExpression degree;

    public Root(String str)
    {
        super(str.substring(1, Analyzer.findCommaPosition(str)));
        this.degree = Analyzer.disassemble(str.substring(Analyzer.findCommaPosition(str) + 1, str.length() - 1));
    }

    @Override
    public double calculate()
    {
        if(isNegative)
            return -Math.pow(this.operation.calculate(), 1d / this.degree.calculate());
        else
            return Math.pow(this.operation.calculate(), 1d / this.degree.calculate());
    }

    @Override
    public double calculateDerivative(String nameVariable)
    {
        double deg = degree.calculate();
        double val = this.operation.calculate();
        if(isNegative)
            return -1d / (deg * Math.pow(Math.pow(val, deg-1), 1d / deg)) * this.operation.calculateDerivative(nameVariable);
        else
            return 1d / (deg * Math.pow(Math.pow(val, deg-1), 1d / deg)) * this.operation.calculateDerivative(nameVariable);
    }

    @Override
    public String getDependencies()
    {
        String s1 = operation.getDependencies();
        String s2 = degree.getDependencies();
        if(!s1.isEmpty() && !s2.isEmpty())
            return s1.equals(s2) ? s1 : s1 + ";" + s2;
        else
            return s1.isEmpty() ? s2 : s2.isEmpty() ? s1 : "";
    }


}
