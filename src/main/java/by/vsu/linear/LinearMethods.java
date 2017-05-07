package main.java.by.vsu.linear;

import main.java.by.vsu.matrix.Matrix;
import main.java.by.vsu.matrix.Vector;

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
