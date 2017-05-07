package main.java.by.vsu.diffeq;

import main.java.by.vsu.analyzer.algebra.VariableValuePair;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EulerCauchy extends DiffEquation
{
    public EulerCauchy(String fstr, VariableValuePair vvPair, double a, double b, double h)
    {
        super(fstr, vvPair, a, b, h);
    }

    @Override
    public double[] resolve(int scale, RoundingMode roundingMode)
    {
        for (int i = 1; i < n; i++)
        {
            f.insertValues(initialValues);
            double tmp_res = f.getValue();
            initialValues[0].assign(net[i]);
            initialValues[1].assign(y[i - 1] + h * tmp_res);
            f.insertValues(initialValues);
            y[i] = new BigDecimal(y[i - 1] + h * (tmp_res + f.getValue()) / 2d)
                    .setScale(scale, roundingMode).doubleValue();
        }
        return y;
    }

}
