package by.vsu.core.interpolating;

import by.vsu.core.analyzer.AlgebraicFunction;

public abstract class Interpolating
{
    double[] x, y;
    double a, b;
    double h;

    public Interpolating(double[] x, double[] y)
    {
        this.x = new double[x.length];
        this.y = new double[y.length];
        for(int i = 0; i < x.length; i++)
        {
            this.x[i] = x[i];
            this.y[i] = y[i];
        }
        this.a = this.x[0];
        this.b = this.x[x.length - 1];
        this.h = x[1] - x[0];
    }

    public Interpolating(double a, double b, int h, String fstr)
    {
        AlgebraicFunction af = new AlgebraicFunction(fstr);
        int n = (int)((b - a) / h) + 1;
        this.x = new double[n];
        this.y = new double[n];
        if (a >= b)
        {
            System.out.println("Неверно введены координаты отрезков!");
            return;
        }
        this.x[0] = a;
        af.insertValue(x[0]);
        y[0] = af.getValue();
        for (int i = 1; i < n; i++)
        {
            this.x[i] = x[i - 1];
            af.insertValue(x[0]);
            this.y[i] = af.getValue();
        }
    }

}
