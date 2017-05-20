package by.vsu.core.diffeq;

import by.vsu.core.analyzer.algebra.VariableValuePair;

public class Euler extends DiffEquation {

    public Euler(String function, VariableValuePair vvPair, double a, double b, double h) {
        super(function, vvPair, a, b, h);
    }

    @Override
    public double[] resolve() {
        for (int i = 1; i < this.n; i++) {
            this.f.insertValues(this.initialValues);
            this.y[i] = this.y[i - 1] + this.h * this.f.getValue();
            this.initialValues[0].assign(this.net[i]);
            this.initialValues[1].assign(this.y[i]);
        }
        return this.y;
    }

}
