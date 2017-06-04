package by.vsu.math.methods.diffsys;

import by.vsu.analyzer.operators.VariableValuePair;

public class RungeKutta extends SystemsDiffEquations
{
    public RungeKutta(String[] fstr, VariableValuePair[] pair, double a, double b, double h)
    {
        super(fstr, pair, a, b, h);
    }

    @Override
    public double[][] resolve()
    {
        VariableValuePair[] initialValues = {new VariableValuePair(this.initialValues[0]),
                                                new VariableValuePair(this.initialValues[1]),
                                                new VariableValuePair(this.initialValues[2])};
        int n = (int)((b - a) / h) + 1;
        double[][] yes = new double[f.length][n];
        double[][] K = new double[f.length][4];
        for (int i = 0; i < f.length; i++)
            yes[i][0] = initialValues[i+1].getValue();
        for (int j = 1; j < n; j++)
        {
            for (int i = 0; i < f.length; i++)
            {
                f[i].insertValues(initialValues);
                K[i][0] = f[i].getValue();
            }
            initialValues[0].assign(net[j-1] + h / 2);
            for(int k = 1; k < initialValues.length; k++)
            {
                for (int i = 1; i < initialValues.length; i++)
                    initialValues[i].assign(yes[i-1][j-1] + K[i-1][k-1] * h / 2);
                for (int i = 0; i < f.length; i++)
                {
                    f[i].insertValues(initialValues);
                    K[i][k] = f[i].getValue();
                }
            }
            initialValues[0].assign(net[j-1] + h);
            for (int i = 1; i < initialValues.length; i++)
                initialValues[i].assign(yes[i-1][j-1] + K[i-1][2] * h);
            for (int i = 0; i < f.length; i++)
            {
                f[i].insertValues(initialValues);
                K[i][3] = f[i].getValue();
            }
            for (int i = 0; i < f.length; i++)
                yes[i][j] = yes[i][j-1] + (h / 6d) * (K[i][0] + 2 * K[i][1] + 2 * K[i][2] + K[i][3]);
            initialValues[0].assign(net[j]);
            for (int i = 1; i < initialValues.length; i++)
                initialValues[i].assign(yes[i-1][j]);
        }
        return yes;
    }
}
