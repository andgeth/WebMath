package by.vsu.core.linear;

import by.vsu.core.math.objects.Matrix;
import by.vsu.core.math.objects.Vector;

public abstract class LinearMethods
{
    Matrix m;
    Vector c;

    LinearMethods(Matrix m, Vector c)
    {
        this.m = new Matrix(m);
        this.c = new Vector(c);
    }

    public abstract Vector solve();
}
