package de.qsim.core.utils;

public strictfp class Complex {
	private double imaginary;
	private double real;

	public Complex(double real, double imaginary) {
		this.imaginary = imaginary;
		this.real = real;
	}

	public Complex() {
		this.imaginary = 0.0;
		this.real = 0.0;
	}

	public void set(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getReal() {
		return real;
	}

	public String getRealString() {
		return Double.toString(real);
	}
	
	public double getImaginary() {
		return imaginary;
	}

	public String getImaginaryString() {
		return Double.toString(imaginary);
	}

	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Complex) {
			return (Double.compare(((Complex) o).real, real) == 0
					&& Double.compare(((Complex) o).imaginary, imaginary) == 0);
		}
		return false;
	}

	@Override
	public String toString() {
		return (this.imaginary < 0 ? (String.format("%f%fi", real, imaginary))
				: (String.format("%f+%fi", real, imaginary)));
	}

	public double getArg() {
		return Math.atan2(this.imaginary, this.real);
	}

	public strictfp static Complex add(Complex z1, Complex z2) {
		return new Complex(z1.getReal() + z2.getReal(), z1.getImaginary() + z2.getImaginary());
	}

	public strictfp static Complex multiply(Complex z1, Complex z2) {
		return new Complex(z1.getReal() * z2.getReal() - z1.getImaginary() * z2.getImaginary(),
				z1.getReal() * z2.getImaginary() + z1.getImaginary() * z2.getReal());
	}

	public strictfp static Complex subtract(Complex z1, Complex z2) {

		return new Complex(z1.getReal() - z2.getReal(), z1.getImaginary() - z2.getImaginary());
	}

	public strictfp static Complex divide(Complex z1, Complex z2) {
		Complex numerator = multiply(z1, conjugate(z2));
		double denominator = Math.pow(mod(z2), 2);
		return new Complex(numerator.getReal() / denominator, numerator.getImaginary() / denominator);
	}

	public strictfp static Complex conjugate(Complex z) {

		return new Complex(z.getReal(), -z.getImaginary());
	}

	public strictfp static double mod(Complex z) {

		return Math.sqrt(Math.pow(z.getReal(), 2) + Math.pow(z.getImaginary(), 2));
	}

	public strictfp static Complex square(Complex z) {
		return new Complex(z.getReal() * z.getReal() - z.getImaginary() * z.getImaginary(),
				2 * z.getReal() * z.getImaginary());
	}

	public strictfp static Complex sin(Complex z) {
		double exp = Math.exp(z.getImaginary());
		return new Complex(Math.sin(z.getReal()) * (exp + 1 / exp) / 2.0,
				Math.cos(z.getReal()) * (exp - 1 / exp) / 2.0);
	}

	public strictfp static Complex cos(Complex z) {
		double exp = Math.exp(z.getImaginary());
		return new Complex(Math.cos(z.getReal()) * (exp + 1 / exp) / 2.0,
				-Math.sin(z.getReal()) * (exp - 1 / exp) / 2.0);
	}

	public strictfp static Complex tan(Complex z) {
		return divide(sin(z), cos(z));
	}

	public strictfp static Complex exp(Complex z) {
		double r = Math.exp(z.getReal());
		return new Complex(r * Math.cos(z.getImaginary()), r * Math.sin(z.getImaginary()));
	}

	public strictfp static Complex pow(Complex z, int power) {
		double realValue = z.getReal();
		double imaginaryValue = z.getImaginary();
		for (int i = 0; i < power - 1; i++) {
			double newRealValue = realValue * z.getReal() - imaginaryValue * z.getImaginary();
			double newImaginaryValue = realValue * z.getImaginary() + imaginaryValue * z.getReal();
			realValue = newRealValue;
			imaginaryValue = newImaginaryValue;
		}
		return new Complex(realValue, imaginaryValue);

	}

	public strictfp static Complex inverse(Complex z) {
		return divide(new Complex(1, 0), z);
	}

	public static strictfp Complex multiply(Complex z, double constant) {
		return new Complex(z.getReal() * constant, z.getImaginary() * constant);
	}

	public strictfp static Complex add(Complex z, double constant) {
		return new Complex(z.getReal() + constant, z.getImaginary());
	}

	public strictfp static Complex subtract(Complex z, double constant) {

		return new Complex(z.getReal() - constant, z.getImaginary());
	}

	public strictfp static Complex divide(Complex z, double constant) {
		return new Complex(z.getReal() / constant, z.getImaginary() / constant);
	}
}