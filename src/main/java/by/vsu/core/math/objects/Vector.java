package by.vsu.core.math.objects;

public class Vector {

	private int n;
	private double[] V;

	public Vector(int n, double[] V) {
		this.n = n;
		this.V = new double[n];
		System.arraycopy(V, 0, this.V, 0, n);
	}

	public Vector(Vector VV) {
		n = VV.getN();
		V = new double[n];
		for (int i = 0; i < n; i++) {
			V[i] = VV.getElement(i);
		}
	}

    public Vector(int n) {
    	this.n = n;
    	V = new double[n];
    	for (int i = 0; i < n; i++) {
    		V[i] = 0;
    	}
    }

	public int getN() {
		return n;
	}

	public double[] getV() {
		return V;
	}

	public double getElement(int i) {
		return V[i];
	}

	public void setElement (int i, double h) {
		V[i] = h;
	}

}
