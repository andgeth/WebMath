package main.java.by.vsu.linear;

import main.java.by.vsu.matrix.Matrix;
import main.java.by.vsu.matrix.Vector;

public class JordanGaussSolve extends LinearMethods
{
    public JordanGaussSolve(Matrix m, Vector v)
    {
        super(m, v);
    }

    public Vector solve()
    {
        for (int i = 0; i < m.getN(); i++)
        {
            double aii = m.getElement(i, i);
            if (aii != 0)
            {
                for (int j = m.getN() - 1; j >= i; j--)
                {
                    double h = m.getElement(i, j) / aii;
                    m.setElement(i, j, h);
                }
                double bh = c.getElement(i) / aii;
                c.setElement(i, bh);
                double bi = c.getElement(i);
                for (int k = 0; k < c.getN(); k++)
                    if (k != i)
                    {
                        double h = c.getElement(k) - bi * m.getElement(k, i);
                        c.setElement(k, h);
                    }
                for (int j = m.getN() - 1; j >= i; j--)
                {
                    double aij = m.getElement(i, j);
                    for (int k = 0; k < m.getN(); k++)
                        if (k != i)
                        {
                            double h = m.getElement(k, j) - aij * m.getElement(k, i);
                            m.setElement(k, j, h);
                        }
                }
            }
            else
            {
                for (int k = i; k < m.getN(); k++)
                    if (m.getElement(k, i) != 0)
                    {
                        for (int j = i; j < m.getN(); j++)
                        {
                            double h1 = m.getElement(i, j);
                            double h2 = m.getElement(k, j);
                            m.setElement(i, j, h2);
                            m.setElement(k, j, h1);
                        }
                        double b1 = c.getElement(i);
                        double b2 = c.getElement(k);
                        c.setElement(i, b2);
                        c.setElement(k, b1);
                        i--;
                        break;
                    }
            }
        }
        return c;
    }
}
