package main.java.by.vsu.linear;

import main.java.by.vsu.matrix.*;

public class SweepMethod extends LinearMethods
{
    double[] A;
    double[] B;
    double[] C;

    public SweepMethod(Matrix m, Vector c)
    {
        super(m, c);
        int n = m.getN();
        A = new double[n];
        B = new double[n];
        C = new double[n];
        A[0] = 0;
        A[n-1] = m.getElement(n-1, n-2);
        B[0] = m.getElement(0, 0);
        B[n-1] = m.getElement(n-1, n-1);
        C[0] = m.getElement(0, 1);
        for(int i = 1; i < n - 1; i++)
        {
            A[i] = m.getElement(i, i-1);
            B[i] = m.getElement(i, i);
            C[i] = m.getElement(i, i+1);
        }
    }

    public Vector solve()
    {
        int n = c.getN() - 1;
        Vector x = new Vector(c.getN());
        double[] a = new double[n];
        double[] b = new double[c.getN()];
        a[0] = -C[0] / B[0];
        b[0] = c.getElement(0) / B[0];
        for(int i = 1; i < n; i++)
        {
            a[i] = -C[i] / (B[i] + A[i] * a[i-1]);
            b[i] = (c.getElement(i) - A[i] * b[i-1]) / (B[i] + A[i] * a[i-1]);
        }
        b[n] = (c.getElement(n) - A[n] * b[n-1]) / (B[n] + A[n] * a[n-1]);
        x.setElement(n, b[n]);
        for(int i = n - 1; i >= 0; i--)
            x.setElement(i, a[i] * x.getElement(i+1) + b[i]);
        return x;
    }
}
