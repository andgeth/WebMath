package by.vsu.math.methods.diffeq;

import by.vsu.analyzer.operators.VariableValuePair;

public class RungeKutta extends DiffEquation {

    public RungeKutta(String fstr, VariableValuePair vvPair, double a, double b, double h) {
        super(fstr, vvPair, a, b, h);
    }

    @Override
    public double[] resolve() {
        for (int i = 1; i < n; i++) {
            f.insertValues(initialValues);
            double K1 = f.getValue();
            initialValues[0].assign(net[i - 1] + h / 2d);
            initialValues[1].assign(y[i - 1] + h * K1 / 2d);

            f.insertValues(initialValues);
            double K2 = f.getValue();
            initialValues[0].assign(net[i - 1] + h / 2d);
            initialValues[1].assign(y[i - 1] + h * K2 / 2d);

            f.insertValues(initialValues);
            double K3 = f.getValue();
            initialValues[0].assign(net[i - 1] + h);
            initialValues[1].assign(y[i - 1] + h * K3);

            f.insertValues(initialValues);
            double K4 = f.getValue();

            y[i] = y[i - 1] + (K1 + 2 * K2 + 2 * K3 + K4) * h / 6d;
        }
        return y;
    }

}
