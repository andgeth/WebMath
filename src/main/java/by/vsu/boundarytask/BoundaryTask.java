package main.java.by.vsu.boundarytask;

import main.java.by.vsu.analyzer.AlgebraicFunction;

import java.math.RoundingMode;

public abstract class BoundaryTask {
    AlgebraicFunction px, qx, fx;
    double a, b;
    double h;
    double alpha1, alpha2;
    double beta1, beta2;
    double gamma1, gamma2;

    BoundaryTask(
            String px, String qx, String fx, double a, double b, double h, double alpha1, double alpha2, double beta1,
            double beta2, double gamma1, double gamma2) {
        this.px = new AlgebraicFunction(px);
        this.qx = new AlgebraicFunction(qx);
        this.fx = new AlgebraicFunction(fx);
        this.a = a;
        this.b = b;
        this.h = h;
        this.alpha1 = alpha1;
        this.alpha2 = alpha2;
        this.beta1 = beta1;
        this.beta2 = beta2;
        this.gamma1 = gamma1;
        this.gamma2 = gamma2;
    }

    public abstract double[] resolve(int scale, RoundingMode roundingMode);
}
