package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.gate.IGate;
import de.qsim.core.qubit.QuBit;

public class SimulatorRail extends AbstractElement {
	public static String TYPE = "rail";
	private List<QuBit> qubitList;
	private List<IGate> gateList;
	private String name;
	private ISimulatorElement parent;
	
	public SimulatorRail(String name, ISimulatorElement parent) {
		super();
		gateList = new ArrayList<>();
		qubitList = new ArrayList<>();
		this.name = name;
		this.parent = parent;
	}

	public SimulatorRail(Element element, ISimulatorElement parent) throws Exception {
		super();
		this.parent = parent;
		loadNode();
		loadChildren();
	}

	@Override
	protected void loadChildren(Element child) throws Exception {
		final String nodeName = child.getNodeName();
		// if (nodeName.equalsIgnoreCase(SimplePage.SIMPLE_TYPE)) {
		// final SimplePage page = new SimplePage(child, this);
		// genList.add(page);
		// }
	}

	@Override
	protected void loadNode() throws Exception {
		this.name = getRequiredAttribute("name");
	}

	@Override
	public Element saveElement(Element xmlElement) {
		Element node = xmlElement.getOwnerDocument().createElement(TYPE);
		node.setAttribute("name", name);
		xmlElement.appendChild(node);
		for (int index = 0; index < qubitList.size(); index++) {
			QuBit qusimBit = qubitList.get(index);
			Element xmlQuBit = xmlElement.getOwnerDocument().createElement(QuBit.TYPE);
			xmlQuBit.setAttribute("r1", qusimBit.getQubit()[0].getRealString());
			xmlQuBit.setAttribute("i1", qusimBit.getQubit()[0].getImaginaryString());
			xmlQuBit.setAttribute("r2", qusimBit.getQubit()[1].getRealString());
			xmlQuBit.setAttribute("i2", qusimBit.getQubit()[1].getImaginaryString());
			xmlQuBit.setAttribute("index", Integer.toString(index));
			node.appendChild(xmlQuBit);
		}
		
		for (int index = 0; index < gateList.size(); index++) {
			IGate qusimGate = gateList.get(index);
			Element xmlGate = xmlElement.getOwnerDocument().createElement(IGate.TYPE);
			xmlGate.setAttribute("name", qusimGate.toString());
			xmlGate.setAttribute("index", Integer.toString(index));
			node.appendChild(xmlGate);
		}

		return xmlElement;
	}

	@Override
	public QuBit[] perform() throws Exception {
		for (IGate gate : gateList) {
			// qubitList = gate.applyGate(inputQubit, targetPosition,
			// conditions, noOfEntangledQubits);
		}
		return (QuBit[]) qubitList.toArray();
	}

	public void addQuBit(QuBit quBit) {
		qubitList.add(quBit);
	}

	public void addGate(IGate gate) {
		gateList.add(gate);
	}

	public void removeGate(int index) {
		gateList.remove(index);
	}

	public void removeGate(IGate gate) {
		gateList.remove(gate);
	}

	public void removeQuBit(int index) {
		qubitList.remove(index);
	}

	public void removeQuBit(QuBit quBit) {
		qubitList.remove(quBit);
	}

	@Override
	public void loadElement(Element xmlElement) {
		// TODO Auto-generated method stub
	}

}