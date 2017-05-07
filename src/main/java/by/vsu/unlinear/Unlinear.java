package main.java.by.vsu.unlinear;

import main.java.by.vsu.analyzer.AlgebraicFunction;

public abstract class Unlinear {

    AlgebraicFunction f;
    double x0;
    double a;
    double b;

    Unlinear(String str, double x0, double a, double b) {
        f = new AlgebraicFunction(str);
        this.x0 = x0;
        this.a = a;
        this.b = b;
    }

    Unlinear(String str, double x0) {
        f = new AlgebraicFunction(str);
        this.x0 = x0;
    }

    public abstract double resolve(double e);

}
