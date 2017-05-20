package by.vsu.core.diffeq;

import by.vsu.core.analyzer.AlgebraicFunction;
import by.vsu.core.analyzer.algebra.VariableValuePair;

public abstract class DiffEquation {

    AlgebraicFunction f;
    VariableValuePair[] initialValues;
    double[] net;
    double[] y;
    double h;
    int n;
    int precision;

    DiffEquation(String fstr, VariableValuePair val, double a, double b, double h) {
        this.f = new AlgebraicFunction(fstr);
        this.h = h;
        this.n = (int) ((b - a) / h);
        this.initialValues = new VariableValuePair[2];
        this.initialValues[1] = new VariableValuePair(val);
        this.net = new double[n];
        this.y = new double[n];
        this.y[0] = this.initialValues[1].getValue();
        String[] dependOf = f.getDependencies().split(";");
        initialValues[0] = new VariableValuePair(dependOf[0].equals(val.getNameVariable()) ? dependOf[1] : dependOf[0], a);
        this.net[0] = this.initialValues[0].getValue();
        for (int i = 1; i < n; i++) {
            this.net[i] = this.net[i - 1] + h;
        }
    }

    public abstract double[] resolve();
}
