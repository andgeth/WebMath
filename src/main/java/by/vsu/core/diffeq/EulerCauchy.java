package by.vsu.core.diffeq;

import by.vsu.core.analyzer.algebra.VariableValuePair;

public class EulerCauchy extends DiffEquation {

    public EulerCauchy(String fstr, VariableValuePair vvPair, double a, double b, double h) {
        super(fstr, vvPair, a, b, h);
    }

    @Override
    public double[] resolve() {
        for (int i = 1; i < n; i++) {
            f.insertValues(initialValues);
            double tmp_res = f.getValue();
            initialValues[0].assign(net[i]);
            initialValues[1].assign(y[i - 1] + h * tmp_res);
            f.insertValues(initialValues);
            y[i] = y[i - 1] + h * (tmp_res + f.getValue()) / 2d;
        }
        return y;
    }

}
