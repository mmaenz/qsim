package de.qsim.core.simulator.model;

import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.qubit.QuBit;

public interface IQSElement {
	public abstract Element saveElement(Element xmlParent);
	public abstract QuBit[] perform() throws Exception;
	public List<IQSElement> getGenList();
}
