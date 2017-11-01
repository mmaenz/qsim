package de.qsim.core.simulator.model;

import org.w3c.dom.Element;

import de.qsim.core.gate.IGate;
import de.qsim.core.qubit.QuBit;

public interface IQuSimElement {
	public abstract Element saveElement(Element element);
	public abstract QuBit[] perform() throws Exception;
	public abstract void loadElement(Element element);
}
