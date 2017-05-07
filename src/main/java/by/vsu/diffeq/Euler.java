package main.java.by.vsu.diffeq;

import main.java.by.vsu.analyzer.algebra.VariableValuePair;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Euler extends DiffEquation
{
    public Euler(String fstr, VariableValuePair vvPair, double a, double b, double h)
    {
        super(fstr, vvPair, a, b, h);
    }

    @Override
    public double[] resolve(int scale, RoundingMode roundingMode)
    {
        for (int i = 1; i < n; i++)
        {
            f.insertValues(initialValues);
            y[i] = new BigDecimal(y[i - 1] + h * f.getValue())
                    .setScale(scale, roundingMode).doubleValue();
            initialValues[0].assign(net[i]);
            initialValues[1].assign(y[i]);
        }
        return y;
    }
}
