package de.qsim.core.model.qubit;

import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.utils.Complex;

public class QuBit extends AbstractQuBit {
	public static String TYPE = "qubit";
	
	
	public QuBit(Element element, Project project, IElement parent) throws Exception {
		super(element, project, parent);
	}

	public QuBit(String name, Complex no0, Complex no1) {
		super(name, no0, no1);
	}

	/**
	 * Constructs a new <code>Qubit</code> object.
	 * 
	 * @param qubitVector
	 *            an array of 2 complex numbers
	 */
	public QuBit(String name, Complex[] qubitVector) {
		super(name, qubitVector);
	}

	/**
	 * Return the qubit represented as an array of 2 complex numbers.
	 * 
	 * @return qubit
	 */

	public Complex[] getComplex() {
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
			if (this.qubitVector.length != ((QuBit) o).getComplex().length) {
				return false;
			}
			for (int i = 0; i < this.qubitVector.length; i++) {
				if (this.qubitVector[i].equals(((QuBit) o).getComplex()[i]) == false) {
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

	public boolean isValid() {
		double sum = 0.0;
		for (Complex c : this.qubitVector) {
			double mod = Complex.mod(c);
			sum += mod * mod;
		}
		return (sum == 1.0);
	}

	@Override
	public Element saveElement(Element xmlParent) {
		Element node = xmlParent.getOwnerDocument().createElement(TYPE);
		node.setAttribute("name", getName());
		node.setAttribute("r1", Double.toString(qubitVector[0].getReal()));
		node.setAttribute("r2", Double.toString(qubitVector[1].getReal()));
		node.setAttribute("i1", Double.toString(qubitVector[0].getImaginary()));
		node.setAttribute("i2", Double.toString(qubitVector[1].getImaginary()));
		xmlParent.appendChild(node);
		return xmlParent;
	}

	@Override
	public List<QuBit> perform() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuBit> step() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
