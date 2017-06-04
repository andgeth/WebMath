package by.vsu.math.methods.diffeq;

import by.vsu.analyzer.AlgebraicFunction;
import by.vsu.analyzer.operators.VariableValuePair;

public abstract class DiffEquation {

    AlgebraicFunction f;
    VariableValuePair[] initialValues;
    double[] net;
    double[] y;
    double h;
    int n;

    DiffEquation(String fstr, VariableValuePair val, double a, double b, double h) {
        this.f = new AlgebraicFunction(fstr);
        String[] dependOn = this.f.getDependencies().split(";");
        if (dependOn.length == 1) {
            this.f = new AlgebraicFunction(fstr + "+"+dependOn[0]+"tmp*0");
            dependOn = f.getDependencies().split(";");
        }
        this.h = h;
        this.n = (int) ((b - a) / h) + 1;
        this.initialValues = new VariableValuePair[2];
        this.initialValues[1] = new VariableValuePair(val);
        this.net = new double[this.n];
        this.y = new double[this.n];
        this.y[0] = this.initialValues[1].getValue();
        this.initialValues[0] = new VariableValuePair(dependOn[0].equals(val.getNameVariable()) ? dependOn[1] : dependOn[0], a);
        this.net[0] = this.initialValues[0].getValue();
        for (int i = 1; i < this.n; i++) {
            this.net[i] = this.net[i - 1] + h;
        }
    }

    public abstract double[] resolve();
}
