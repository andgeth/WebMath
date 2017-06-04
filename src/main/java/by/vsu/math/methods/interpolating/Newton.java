package by.vsu.math.methods.interpolating;

import by.vsu.analyzer.AlgebraicFunction;

import java.util.Arrays;
import java.util.Locale;

public class Newton extends Interpolating implements InterpolationPolynomial {

    int n;
    int[] points;

    public Newton(double[] x, double[] y, String[] points) {
        super(x, y);
        this.n = points.length;
        this.points = new int[n];
        for (int i = 0; i < n; i++) {
            this.points[i] = Integer.parseInt(points[i]);
        }
    }

    public Newton(double a, double b, int h, String fstr) {
        super(a, b, h, fstr);
    }

    public double calcFiniteDifferences(int... indexes) {
        if (indexes.length != 1) {
            double val1 = calcFiniteDifferences(Arrays.copyOfRange(indexes, 0, indexes.length - 1));
            double val2 = calcFiniteDifferences(Arrays.copyOfRange(indexes, 1, indexes.length));
            return (val2 - val1) / (x[indexes[indexes.length - 1]] - x[indexes[0]]);
        } else {
            return y[indexes[0]];
        }
    }

    @Override
    public AlgebraicFunction interpolate() {
        int[] ind = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            ind[i] = points[0] + i;
        }
        if (n > 4) {
            return null;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(y[points[0]] + "+"));
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("(x-").append(x[points[j]]).append(")*");
            }
            sb.append(String.format(new Locale("en", "GB"), "%f", calcFiniteDifferences(Arrays.copyOfRange(ind, 0, i + 1))));
            if (i < n) {
                sb.append("+");
            }
        }
        return new AlgebraicFunction(sb.toString());
    }
}