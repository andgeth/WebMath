package by.vsu.core.diffeq;

import by.vsu.core.analyzer.algebra.VariableValuePair;

public class BetterEuler extends DiffEquation {

    public BetterEuler(String fstr, VariableValuePair vvPair, double a, double b, double h) {
        super(fstr, vvPair, a, b, h);
    }

    @Override
    public double[] resolve() {
        for (int i = 1; i < n; i++) {
            f.insertValues(initialValues);
            initialValues[0].assign(net[i - 1] + h / 2d);
            initialValues[1].assign(y[i - 1] + h * f.getValue() / 2d);
            f.insertValues(initialValues);
            y[i] = y[i - 1] + h * f.getValue();
        }
        return y;
    }

}
