package main.java.by.vsu.interpolating;

import main.java.by.vsu.analyzer.AlgebraicFunction;

public class Lagrange extends Interpolating implements InterpolationPolynomial
{
    private int n;
    private int[] points;

    public Lagrange(double[] x, double[] y, String[] points)
    {
        super(x, y);
        this.n = points.length;
        this.points = new int[n];
        for(int i = 0; i < n; i++)
            this.points[i] = Integer.parseInt(points[i]);
    }

    public Lagrange(double a, double b, int h, String fstr)
    {
        super(a, b, h, fstr);
    }

    @Override
    public AlgebraicFunction interpolate()
    {
        if (n > 4)
            return null;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                if(i != j)
                    sb.append("((x-").append(x[points[j]]).append(")/(").append(x[points[i]]).append("-").append(x[points[j]]).append("))*");
            sb.append(y[points[i]]);
            if(i != n - 1)
                sb.append("+");
        }
        return new AlgebraicFunction(sb.toString());
    }
}