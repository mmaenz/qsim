package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.qubit.QuBit;

public class SimulatorRegister extends AbstractElement {
	public static String TYPE = "register";
	private List<SimulatorRail> railList;
	private String name;
	private ISimulatorElement parent;

	public SimulatorRegister(String name, ISimulatorElement parent) {
		super();
		railList = new ArrayList<>();
		this.name = name;
		this.parent = parent;
	}

	
	public SimulatorRegister(Element element, ISimulatorElement parent) throws Exception {
		super();
		railList = new ArrayList<>();
		loadNode();
		loadChildren();
	}

	@Override
	protected void loadChildren(Element child) throws Exception {
		final String nodeName = child.getNodeName();
//		if (nodeName.equalsIgnoreCase(SimplePage.SIMPLE_TYPE)) {
//			final SimplePage page = new SimplePage(child, this);
//			railList.add(page);
//		}
	}

	@Override
	protected void loadNode() throws Exception {
		this.name = getRequiredAttribute("name");
	}

	@Override
	public QuBit[] perform() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadElement(Element xmlElement) {
		// TODO Auto-generated method stub
	}

	public SimulatorRail addRail(String name) {
		SimulatorRail rail = new SimulatorRail(name, this);
		railList.add(rail);
		return rail;
	}
	
	public void removeRail(int index) {
		railList.remove(index);
	}
	
	public void removeRail(SimulatorRail rail) {
		railList.remove(rail);
	}

	@Override
	public Element saveElement(Element xmlElement) {
		Element node = xmlElement.getOwnerDocument().createElement(TYPE);
		node.setAttribute("name", name);
		xmlElement.appendChild(node);
		for (ISimulatorElement simElement : railList) {
			simElement.saveElement(node);
		}
		return xmlElement;
	}

}
