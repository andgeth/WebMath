package main.java.by.vsu.diffeq;

import main.java.by.vsu.analyzer.algebra.VariableValuePair;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BetterEuler extends DiffEquation
{
    public BetterEuler(String fstr, VariableValuePair vvPair, double a, double b, double h)
    {
        super(fstr, vvPair, a, b, h);
    }

    @Override
    public double[] resolve(int scale, RoundingMode roundingMode)
    {
        for (int i = 1; i < n; i++)
        {
            f.insertValues(initialValues);
            initialValues[0].assign(net[i - 1] + h / 2d);
            initialValues[1].assign(y[i - 1] + h * f.getValue() / 2d);
            f.insertValues(initialValues);
            y[i] = new BigDecimal(y[i - 1] + h * f.getValue())
                    .setScale(scale, roundingMode).doubleValue();
        }
        return y;
    }


}
