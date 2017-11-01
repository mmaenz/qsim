package de.qsim.core.qubit;

import java.util.Arrays;

import de.qsim.core.utils.Complex;

public class QuBit implements IQuBit {
	public static String TYPE = "qubit";
	protected Complex[] qubitVector;

	public QuBit() {
	}
	
	public QuBit(Complex no0, Complex no1) {
		qubitVector = new Complex[2];
		qubitVector[0] = no0;
		qubitVector[1] = no1;
	}

	/**
	 * Constructs a new <code>Qubit</code> object.
	 * 
	 * @param qubitVector
	 *            an array of 2 complex numbers
	 */
	public QuBit(Complex[] qubitVector) {
		this.qubitVector = Arrays.copyOf(qubitVector, qubitVector.length);
	}

	/**
	 * Return the qubit represented as an array of 2 complex numbers.
	 * 
	 * @return qubit
	 */
	@Override
	public Complex[] getQubit() {
		Complex[] copyOfQubitVector = qubitVector;
		return copyOfQubitVector;
	}

	/**
	 * Return a string representation of the qubit.
	 * 
	 * @return string the representation of the qubit
	 */
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("[ ");
		for (Complex i : qubitVector) {
			output.append(i);
			output.append(" ");
		}
		output.append("]");
		return output.toString();
	}

	/**
	 * Check if passed <code>Qubit</code> is equal to the current.
	 * 
	 * @param o
	 *            the qubit to be checked
	 * @return true if the two qubits are equals, otherwise false
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof QuBit) {
			if (this.qubitVector.length != ((QuBit) o).getQubit().length) {
				return false;
			}
			for (int i = 0; i < this.qubitVector.length; i++) {
				if (this.qubitVector[i].equals(((QuBit) o).getQubit()[i]) == false) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Calculate the hashcode of the qubit.
	 * 
	 * @return int hashcode
	 */
	@Override
	public int hashCode() {
		int hash = 5;
		hash += (this.qubitVector != null ? Arrays.hashCode(qubitVector) : 0);
		return hash;
	}

	/**
	 * Check if qubit state is valid
	 * 
	 * @return true if the state is valid, otherwise false
	 */
	@Override
	public boolean isValid() {
		double sum = 0.0;
		for (Complex c : this.qubitVector) {
			double mod = Complex.mod(c);
			sum += mod * mod;
		}
		return (sum == 1.0);
	}

}
