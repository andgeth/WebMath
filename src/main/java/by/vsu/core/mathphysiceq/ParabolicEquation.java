package by.vsu.core.mathphysiceq;

import by.vsu.core.analyzer.AlgebraicFunction;
import by.vsu.core.analyzer.algebra.VariableValuePair;
import by.vsu.core.linear.SweepMethod;
import by.vsu.core.math.objects.Matrix;
import by.vsu.core.math.objects.Vector;

import java.util.Arrays;

public class ParabolicEquation extends AbstractMathPhysicEquation {

    private AlgebraicFunction initialCondition;
    private AlgebraicFunction f;

    public ParabolicEquation(String initialCondition, String[] boundaryConditions, String f, double a, double b,
                             double a1, double b1, double h, double t) {
        super(boundaryConditions, a, b, a1, b1, h, t);
        this.initialCondition = new AlgebraicFunction(initialCondition);
        this.f = new AlgebraicFunction(f);
    }

    private void fillInitialConditions(double[][] res, int nX) {
        for (int j = 0; j < nX - 1; j++) {
            initialCondition.insertValue(a + h * j);
            res[0][j] = initialCondition.getValue();
        }
    }

    private double[][] clearScheme() {
        checkStabilityCondition(t, h * h / 2.0);
        int nX = (int) ((b - a) / h) + 1;
        int nT = (int) ((b1 - a1) / t) + 1;
        double[][] res = new double[nT][nX];
        VariableValuePair xtPair[] = { new VariableValuePair("x", 0), new VariableValuePair("t", 0) };

        fillBoundaryConditions(res, nX, nT);
        fillInitialConditions(res, nX);

        for (int i = 0; i < nT - 1; i++) {
            for (int j = 1; j < nX - 1; j++) {
                xtPair[0].assign(a + j * h);
                xtPair[1].assign(a1 + i * t);
                f.insertValues(xtPair);
                res[i + 1][j] = res[i][j] + t * ((res[i][j + 1] - 2 * res[i][j] + res[i][j - 1]) / (h * h) + f.getValue());
            }
        }
        return res;
    }

    private double[][] implicitScheme(double weight) {
        double gamma = t / (h * h);
        int nT = (int) ((b1 - a1) / t) + 1;
        int nX = (int) ((b - a) / h) + 1;
        double[][] res = new double[nT][nX];
        double[][] m = new double[nX][nX];
        double[] F = new double[nX];
        VariableValuePair[] xtPair = { new VariableValuePair("x", 0), new VariableValuePair("t", 0) };
        m[0][0] = 1;
        m[nX - 1][nX - 1] = 1;

        fillBoundaryConditions(res, nX, nT);
        fillInitialConditions(res, nX);

        for (int i = 0; i < nT - 1; i++) {
            boundaryConditions[0].insertValue(a1 + t * (i + 1));
            boundaryConditions[1].insertValue(a1 + t * (i + 1));
            F[0] = boundaryConditions[0].getValue();
            F[nX - 1] = boundaryConditions[1].getValue();
            for (int k = 1; k < nX - 1; k++) {
                m[k][k - 1] = weight * gamma;
                m[k][k] = -(1 + 2 * weight * gamma);
                m[k][k + 1] = weight * gamma;
                xtPair[0].assign(a + h * k);
                xtPair[1].assign(a1 + t * k);
                f.insertValues(xtPair);
                F[k] = -(res[i][k] + (1 - weight) * t * ((res[i][k + 1] - 2 * res[i][k] + res[i][k - 1]) / (h * h)) + t * f.getValue());
            }
            SweepMethod sm = new SweepMethod(new Matrix(m), new Vector(F.length, F));
            res[i + 1] = Arrays.copyOf(sm.solve().getV(), nX);
        }
        return res;
    }

    public double[][] solve(double weight) {
        return weight == 0 ? clearScheme() : implicitScheme(weight);
    }

}
