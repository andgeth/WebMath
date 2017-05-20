package by.vsu.core.mathphysiceq;

import by.vsu.core.analyzer.AlgebraicFunction;
import by.vsu.core.math.objects.Matrix;

public class HyperbolicEquation extends AbstractMathPhysicEquation {

    private AlgebraicFunction[] initialCondition = new AlgebraicFunction[2];

    public HyperbolicEquation(String[] initialCondition, String[] boundaryConditions, double a, double b,
                              double a1, double b1, double h, double t) {
        super(boundaryConditions, a, b, a1, b1, h, t);
        for (int i = 0; i < 2; i++) {
            this.initialCondition[i] = new AlgebraicFunction(initialCondition[i]);
        }
    }

    private void fillInitialConditions(double[][] res, int nX) {
        for (int j = 0; j < nX - 1; j++) {
            initialCondition[0].insertValue(a + h * j);
            initialCondition[1].insertValue(a + h * j);
            res[0][j] = initialCondition[0].getValue();
            double x = res[0][j];
            initialCondition[0].insertValue(a + h * (j - 1));
            double x0 = initialCondition[0].getValue();
            initialCondition[0].insertValue(a + h * (j + 1));
            double x1 = initialCondition[0].getValue();
            res[1][j] = res[0][j] + t * initialCondition[1].getValue() + (t * t / 2) * ((x1 - 2 * x + x0) / (h * h));
        }
    }

    private Matrix clearScheme() {
        checkStabilityCondition(t / h, 1);
        int nX = (int) ((b - a) / h) + 1;
        int nT = (int) ((b1 - a1) / t) + 1;
        double[][] res = new double[nT][nX];
        double gamma = t * t / (h * h);

        fillBoundaryConditions(res, nX, nT);
        fillInitialConditions(res, nX);

        for (int i = 1; i < nT - 1; i++) {
            for (int j = 1; j < nX - 1; j++) {
                res[i + 1][j] = 2 * res[i][j] - res[i - 1][j] + gamma * ((res[i][j + 1] - 2 * res[i][j] + res[i][j - 1]));
            }
        }
        return new Matrix(res);
    }

    public Matrix solve() {
        return clearScheme();
    }

}
