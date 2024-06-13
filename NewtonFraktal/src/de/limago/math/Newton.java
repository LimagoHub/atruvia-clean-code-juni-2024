package de.limago.math;

public class Newton {

	private static final int MAXITER = 255;

	private Complex linkeUntereEcke;
	private double breite;

	public Newton() {
		linkeUntereEcke = new Complex(-2.0, -2.0);
		breite = 4;
	}

	public Newton(Complex linkeUntereEcke, double breite) {
		this.linkeUntereEcke = linkeUntereEcke;
		this.breite = breite;
	}

	public Complex createC(int x, int y, int size) {
		double delta = breite / (double) size;
		return new Complex(linkeUntereEcke.re() + x * delta, linkeUntereEcke.im() + y * delta);
	}

	public int iterate(Complex c) {
		int retval = 0;
		Complex x = c;
		for (int i = 0; i < 100; i++) {
			Complex n = f(x).divides(fStrich(x));
			x = x.minus(n);
		}
		if(x.minus(new Complex(1,0)).abs() < 0.00001) return 1;
		if(x.minus(new Complex(-0.5,0.86602540378443864676372317075294)).abs() < 0.00001) return 2;
		if(x.minus(new Complex(-0.5,-0.86602540378443864676372317075294)).abs() < 0.00001) return 3;
		return retval;
	}

	private Complex f(Complex c) {
		Complex result = c.times(c);
		result = result.times(c);
		result = result.minus(new Complex(1,0));
		return result;
	}

	private Complex fStrich(Complex c) {
		Complex result = c.times(c);
		result = result.scale(2.0);
		return result;
	}

}
