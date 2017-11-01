package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.qsim.core.qubit.QuBit;

public class SimulatorProject extends AbstractElement {
	public static final String TYPE = "project";
	private final List<ISimulatorElement> genList;
	private String name;
	
	public SimulatorProject(Element element) throws Exception {
		super(element);
		genList = new ArrayList<>();
		loadNode();
		loadChildren();
	}

	public SimulatorProject(String name) {
		super();
		this.genList = new ArrayList<>();
		this.name = name;
	}
	
	@Override
	protected void loadChildren(Element child) throws Exception {
		final String nodeName = child.getNodeName();
//		if (nodeName.equalsIgnoreCase(SimplePage.SIMPLE_TYPE)) {
//			final SimplePage page = new SimplePage(child, this);
//			genList.add(page);
//		}
	}

	@Override
	protected void loadNode() throws Exception {
		this.name = getRequiredAttribute("name");
	}
	
	@Override
	public QuBit[] perform() throws Exception {
		for (final ISimulatorElement element : genList) {
			element.perform();
		}
		return null;
	}

	public SimulatorRegister addRegister(String name) {
		SimulatorRegister register = new SimulatorRegister(name, this);
		genList.add(register);
		return register;
	}
	
	public void removeRegister(SimulatorRegister register) {
		genList.remove(register);
	}

	public void removeRegister(int index) {
		genList.remove(index);
	}
	
	public Element saveElement(Document xmlDoc) {
		Element element = xmlDoc.createElement("project");
		element.setAttribute("name", this.name);
		xmlDoc.appendChild(element);
		for (ISimulatorElement qusimElement : genList) {
			qusimElement.saveElement(element);
		}
		return element;
	}

	@Override
	public void loadElement(Element element) {
		// TODO Auto-generated method stub
	}

	@Override
	public Element saveElement(Element xmlParent) {
		return null;
	}

}