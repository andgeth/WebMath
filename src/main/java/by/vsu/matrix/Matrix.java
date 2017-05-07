package main.java.by.vsu.matrix;

public class Matrix {

    private int n;
    private int m;
    private double[][] M;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.M = new double[n][m];
    }

    public Matrix(double[][] M) {
        this.n = M.length;
        this.m = M[0].length;
        this.M = new double[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(M[i], 0, this.M[i], 0, m);
        }
    }

    public Matrix(Matrix MM) {
        n = MM.getN();
        M = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = MM.getElement(i, j);
            }
        }
    }

    public Matrix(int n) {
        this.n = n;
        M = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = 0;
            }
        }
    }

    public int getN() {
        return n;
    }

    public double[][] getM() {
        return M;
    }

    public double getElement(int i, int j) {
        return M[i][j];
    }

    public void setElement(int i, int j, double h) {
        M[i][j] = h;
    }

    public double Det() {
        Matrix d = Matrix.toTriangle(this);
        double det = 1;
        for (int i = 0; i < n; i++) {
            det *= d.getElement(i, i);
            if (det == 0) {
                break;
            }
        }
        return det;
    }

    private static Matrix toTriangle(Matrix MM) {
        Matrix MT = new Matrix(MM);
        for (int i = 0; i < MT.getN() - 1; i++) {
            double aii = MT.getElement(i, i);
            if (aii != 0) {
                for (int j = MT.getN() - 1; j >= i; j--) {
                    double aij = MT.getElement(i, j);
                    for (int k = i + 1; k < MT.getN(); k++) {
                        double h = MT.getElement(k, j) - aij * MT.getElement(k, i) / aii;
                        MT.setElement(k, j, h);
                    }
                }
            } else {
                for (int k = i; k < MT.getN(); k++) {
                    if (MT.getElement(k, i) != 0) {
                        for (int j = i; j < MT.getN(); j++) {
                            double h1 = MT.getElement(i, j);
                            double h2 = MT.getElement(k, j) * (-1);
                            MT.setElement(i, j, h2);
                            MT.setElement(k, j, h1);
                        }
                        i--;
                        break;
                    }
                }
            }
        }
        return MT;
    }

    public static Matrix Difference(Matrix M1, Matrix M2) {
        if (M1.n == M2.n) {
            Matrix resM = new Matrix(M1);
            for (int i = 0; i < M1.n; i++) {
                for (int j = 0; j < M1.n; j++) {
                    resM.M[i][j] -= M2.M[i][j];
                }
            }
            return resM;
        }
        return M1;
    }

    public double cubicNorm() {
        double nm = 0;
        for (int i = 0; i < n; i++) {
            double s = 0;
            for (int j = 0; j < n; j++) {
                s += Math.abs(M[i][j]);
            }
            if (s > nm) {
                nm = s;
            }
        }
        return nm;
    }

}
