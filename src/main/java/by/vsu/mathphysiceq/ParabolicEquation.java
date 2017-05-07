package main.java.by.vsu.mathphysiceq;

import main.java.by.vsu.analyzer.AlgebraicFunction;
import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import main.java.by.vsu.linear.SweepMethod;
import main.java.by.vsu.matrix.Matrix;
import main.java.by.vsu.matrix.Vector;

import java.util.Arrays;

public class ParabolicEquation
{
    AlgebraicFunction initialCondition;
    AlgebraicFunction[] boundaryConditions = new AlgebraicFunction[2];
    AlgebraicFunction f;
    double a, b, a1, b1;
    double h, t;

    public ParabolicEquation(String initialCondition, String[] boundaryConditions, String f, double a, double b, double a1,
                             double b1, double h, double t)
    {
        this.initialCondition = new AlgebraicFunction(initialCondition);
        for(int i = 0; i < 2; i++)
            this.boundaryConditions[i] = new AlgebraicFunction(boundaryConditions[i]);
        this.f = new AlgebraicFunction(f);
        this.a = a;
        this.b = b;
        this.a1 = a1;
        this.b1 = b1;
        this.h = h;
        this.t = t;
    }

    private Matrix clearScheme()
    {
        if(t <= h * h / 2.0)
        {
            int nX = (int)((b - a) / h) + 1;
            int nT = (int)((b1 - a1) / t) + 1;
            double[][] res = new double[nT][nX];
            for(int i = 0; i < nT; i++)
            {
                boundaryConditions[0].insertValue(a1 + t * i);
                res[i][0] = boundaryConditions[0].getValue();
                boundaryConditions[1].insertValue(a1 + t * i);
                res[i][nX-1] = boundaryConditions[1].getValue();
            }
            for(int j = 1; j < nX - 1; j++)
            {
                initialCondition.insertValue(a + h * j);
                res[0][j] = initialCondition.getValue();
            }
            VariableValuePair xtPair[] = {new VariableValuePair("x", 0), new VariableValuePair("t", 0)};
            for (int i = 0; i < nT - 1; i++)
                for (int j = 1; j < nX - 1; j++)
                {
                    xtPair[0].assign(a + j * h);
                    xtPair[1].assign(a1 + i * t);
                    f.insertValues(xtPair);
                    res[i+1][j] = res[i][j] + t * ((res[i][j+1] - 2 * res[i][j] + res[i][j-1]) / (h * h) + f.getValue());
                }
            return new Matrix(res);
        }
        else
            return null;
    }

    private Matrix implicitScheme(double weight)
    {
        double gamma = t / (h * h);
        int nT = (int)((b1 - a1) / t) + 1;
        int nX = (int)((b - a) / h) + 1;
        double[][] res = new double[nT][nX];
        double[][] m = new double[nX][nX];
        double[] F = new double[nX];
        VariableValuePair[] xtPair = {new VariableValuePair("x", 0),
                                        new VariableValuePair("t", 0)};
        m[0][0] = 1;
        m[nX-1][nX-1] = 1;
        for (int i = 0; i < nT; i++)
        {
            boundaryConditions[0].insertValue(a1 + t * i);
            boundaryConditions[1].insertValue(a1 + t * i);
            res[i][0] = boundaryConditions[0].getValue();
            res[i][nX-1] = boundaryConditions[1].getValue();
        }
        for (int j = 0; j < nX; j++)
        {
            initialCondition.insertValue(a + h * j);
            res[0][j] = initialCondition.getValue();
        }

        for(int i = 0; i < nT - 1; i++)
        {
            boundaryConditions[0].insertValue(a1 + t * (i + 1));
            boundaryConditions[1].insertValue(a1 + t * (i + 1));
            F[0] = boundaryConditions[0].getValue();
            F[nX-1] = boundaryConditions[1].getValue();
            for (int k = 1; k < nX - 1; k++)
            {
                m[k][k-1] = weight * gamma;
                m[k][k] = -(1 + 2 * weight * gamma);
                m[k][k+1] = weight * gamma;
                xtPair[0].assign(a + h * k);
                xtPair[1].assign(a1 + t * k);
                f.insertValues(xtPair);
                F[k] = -(res[i][k] + (1 - weight) * t * ((res[i][k+1] - 2 * res[i][k] + res[i][k-1]) / (h * h)) +
                        t * f.getValue());
            }
            SweepMethod sm = new SweepMethod(new Matrix(m), new Vector(F.length, F));
            res[i+1] = Arrays.copyOf(sm.solve().getV(), nX);
        }
        return new Matrix(res);
    }

    public Matrix solve(double weight)
    {
        if(weight == 0)
            return clearScheme();
        else
            return implicitScheme(weight);
    }
}
