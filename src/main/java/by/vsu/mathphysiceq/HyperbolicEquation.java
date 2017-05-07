package main.java.by.vsu.mathphysiceq;

import main.java.by.vsu.analyzer.AlgebraicFunction;
import main.java.by.vsu.analyzer.algebra.VariableValuePair;
import main.java.by.vsu.matrix.Matrix;

public class HyperbolicEquation
{
    AlgebraicFunction[] initialCondition = new AlgebraicFunction[2];
    AlgebraicFunction[] boundaryConditions = new AlgebraicFunction[2];
    AlgebraicFunction f;
    double a, b, a1, b1;
    double h, t;

    public HyperbolicEquation(String[] initialCondition, String[] boundaryConditions, String f, double a, double b, double a1,
                       double b1, double h, double t)
    {
        for(int i = 0; i < 2; i++)
        {
            this.boundaryConditions[i] = new AlgebraicFunction(boundaryConditions[i]);
            this.initialCondition[i] = new AlgebraicFunction(initialCondition[i]);
        }
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
        if(t / h <= 1)
        {
            int nX = (int)((b - a) / h) + 1;
            int nT = (int)((b1 - a1) / t) + 1;
            double[][] res = new double[nT][nX];
            double gamma = t * t / (h * h);
            VariableValuePair xtPair[] = {new VariableValuePair("x", a), new VariableValuePair("t", 0)};
            for(int i = 0; i < nT; i++)
            {
                boundaryConditions[0].insertValue(a1 + t * i);
                res[i][0] = boundaryConditions[0].getValue();
                boundaryConditions[1].insertValue(a1 + t * i);
                res[i][nX-1] = boundaryConditions[1].getValue();
            }
            for(int j = 1; j < nX - 1; j++)
            {
                initialCondition[0].insertValue(a + h * j);
                initialCondition[1].insertValue(a + h * j);
                res[0][j] = initialCondition[0].getValue();
                double x = res[0][j];
                initialCondition[0].insertValue(a + h * (j - 1));
                double x0 = initialCondition[0].getValue();
                initialCondition[0].insertValue(a + h * (j + 1));
                double x1 = initialCondition[0].getValue();
                f.insertValues(xtPair);
                res[1][j] = res[0][j] + t * initialCondition[1].getValue() + (t * t / 2) * ((x1 - 2 * x + x0) / (h * h));
                xtPair[0].assign(a + h * j);
            }
            for (int i = 1; i < nT - 1; i++)
                for (int j = 1; j < nX - 1; j++)
                {
                    xtPair[0].assign(a + j * h);
                    xtPair[1].assign(a1 + i * t);
                    f.insertValues(xtPair);
                    res[i+1][j] = 2 * res[i][j] - res[i-1][j] +  gamma * ((res[i][j+1] - 2 * res[i][j] + res[i][j-1]));
                }
            return new Matrix(res);
        }
        else
            return null;
    }

    public Matrix solve()
    {
        return clearScheme();
    }

}
