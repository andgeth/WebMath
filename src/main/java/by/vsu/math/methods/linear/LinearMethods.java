package by.vsu.math.methods.linear;

import by.vsu.math.objects.Matrix;
import by.vsu.math.objects.Vector;

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
