package by.vsu.core.interpolating;

import by.vsu.core.analyzer.AlgebraicFunction;
import by.vsu.core.linear.SweepMethod;
import by.vsu.core.math.objects.Matrix;
import by.vsu.core.math.objects.Spline;
import by.vsu.core.math.objects.Vector;

import java.util.Arrays;

public class SplineInterpolating extends Interpolating {

    public SplineInterpolating(double[] x, double[] y) {
        super(x, y);
    }

    public Spline createSpline() {
        int n = this.x.length;
        double[][] coeff = new double[4][n];
        coeff[0] = Arrays.copyOf(y, y.length);
        Matrix C = new Matrix(n);
        Vector R = new Vector(n);
        C.setElement(0, 0, 1);
        C.setElement(n - 1, n - 1, 1);
        for (int i = 1; i < n - 1; i++) {
            C.setElement(i, i - 1, this.h);
            C.setElement(i, i, 2 * (this.h + this.h));
            C.setElement(i, i + 1, this.h);
            R.setElement(i, 6 * ((this.y[i + 1] - this.y[i]) / this.h - (this.y[i] - this.y[i - 1]) / this.h));
        }
        SweepMethod sm = new SweepMethod(C, R);
        Vector CC = sm.solve();
        for (int i = 1; i < n; i++) {
            coeff[2][i] = CC.getElement(i);
            coeff[3][i] = (coeff[2][i] - coeff[2][i - 1]) / this.h;
            coeff[1][i] = coeff[2][i] * this.h / 2 - coeff[3][i] * this.h * this.h / 6 + (y[i] - y[i - 1]) / this.h;
        }
        AlgebraicFunction[] af = new AlgebraicFunction[n - 1];
        for (int i = 1; i < n; i++) {
            af[i - 1] = new AlgebraicFunction(coeff[0][i] + "+" + coeff[1][i] + "*" + "(x-" + x[i] + ")+" + coeff[2][i] + "*((x-" + x[i] + ")^2)/2+" + coeff[3][i] + "*((x-" + x[i] + ")^3)/6");
        }
        return new Spline(af, x);
    }

}
