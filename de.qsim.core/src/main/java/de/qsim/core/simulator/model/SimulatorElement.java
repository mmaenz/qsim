package de.qsim.core.simulator.model;

import org.w3c.dom.Element;

import de.qsim.core.gate.IGate;
import de.qsim.core.qubit.QuBit;

public class SimulatorElement extends AbstractElement {
	public static final String TYPE = "reference";
	private String name;
	
	public SimulatorElement(Element element, SimulatorProject project, ISimulatorElement parent) throws Exception {
		super(element);
	}
	
	@Override
	public QuBit[] perform() throws Exception {
		return null;
	}

	@Override
	public Element saveElement(Element element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadElement(Element element) {
		// TODO Auto-generated method stub
		
	}

}