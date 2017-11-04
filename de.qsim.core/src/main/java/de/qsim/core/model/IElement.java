package de.qsim.core.model;

import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.qubit.QuBit;

public interface IElement {
	public abstract Element saveElement(Element xmlParent);
	public abstract List<QuBit> perform() throws Exception;
	public abstract List<QuBit> step() throws Exception;
}
