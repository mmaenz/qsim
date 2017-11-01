package de.qsim.core.simulator.model;

import org.w3c.dom.Element;

import de.qsim.core.gate.IGate;
import de.qsim.core.qubit.QuBit;

public interface ISimulatorElement {
	public abstract Element saveElement(Element xmlParent);
	public abstract QuBit[] perform() throws Exception;
	public abstract void loadElement(Element xmlElement);
}
