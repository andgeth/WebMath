package by.vsu.math.methods.boundarytask;

import by.vsu.analyzer.operators.VariableValuePair;
import by.vsu.math.methods.diffsys.RungeKutta;
import by.vsu.math.methods.linear.JordanGaussSolve;
import by.vsu.math.objects.Matrix;
import by.vsu.math.objects.Vector;

public class ReductionMethod extends BoundaryTask {

    public ReductionMethod(String px, String qx, String fx, double a, double b, double h, double alpha1, double alpha2, double beta1,
            double beta2, double gamma1, double gamma2) {
        super(px, qx, fx, a, b, h, alpha1, alpha2, beta1, beta2, gamma1, gamma2);
    }

    @Override
    public double[] resolve() {
        int n = (int) ((b - a) / h) + 1;
        String[][] fstr = {
                {"sx", fx.getStrView() + "-sx*(" + px.getStrView() + ")-yx*(" + qx.getStrView() + ")"},
                {"sx", "-sx*(" + px.getStrView() + ")-yx*(" + qx.getStrView() + ")"},
                {"sx", "-sx*(" + px.getStrView() + ")-yx*(" + qx.getStrView() + ")"}
        };
        VariableValuePair[] pairs = { new VariableValuePair("yx", 1), new VariableValuePair("sx", 0)};
        double[][] resY1 = new RungeKutta(fstr[1], pairs, a, b, h).resolve();
        pairs[0].assign(0);
        double[][] resY0 = new RungeKutta(fstr[0], pairs, a, b, h).resolve();
        pairs[1].assign(1);
        double[][] resY2 = new RungeKutta(fstr[2], pairs, a, b, h).resolve();
        double[][] resultSystem = {
                { alpha1 * resY1[0][0] + beta1 * resY1[1][0], alpha1 * resY2[0][0] + beta1 * resY2[1][0] },
                { alpha2 * resY1[0][n - 1] + beta2 * resY1[1][n - 1], alpha2 * resY2[0][n - 1] + beta2 * resY2[1][n - 1] }
        };
        double[] V = {
                gamma1 - alpha1 * resY0[0][0] - beta1 * resY0[1][0],
                gamma2 - alpha2 * resY0[0][n - 1] - beta2 * resY0[1][n - 1]
        };
        Vector coefficients = new JordanGaussSolve(new Matrix(resultSystem), new Vector(2, V)).solve();
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = resY0[0][i] + coefficients.getElement(0) * resY1[0][i] + coefficients.getElement(1) * resY2[0][i];
        }
        return result;
    }

}
