package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.gate.GateFactory;
import de.qsim.core.gate.GateType;
import de.qsim.core.gate.IGate;
import de.qsim.core.qubit.QuBit;
import de.qsim.core.utils.Complex;
import de.qsim.core.utils.Pair;

public class QSRail extends AbstractQSElement {
	public static String TYPE = "rail";
	private List<Pair> qubitList;
	private List<Pair> gateList;
	private String name;
	private IQSElement parent;

	public QSRail(String name, IQSElement parent) {
		super();
		gateList = new ArrayList<>();
		qubitList = new ArrayList<>();
		this.name = name;
		this.parent = parent;
	}

	public QSRail(Element element, IQSElement parent) throws Exception {
		super(element);
		gateList = new ArrayList<>();
		qubitList = new ArrayList<>();
		this.parent = parent;
		loadNode();
		loadChildren();
	}

	@Override
	protected void loadChildren(Element xmlElement) throws Exception {
		String text = xmlElement.getNodeName();
		if (text.equalsIgnoreCase(QuBit.TYPE)) {
			double r = getDoubleValueFromAttribute(xmlElement, "r1");
			double i = getDoubleValueFromAttribute(xmlElement, "i1");
			Complex no1 = new Complex(r, i);
			r = getDoubleValueFromAttribute(xmlElement, "r2");
			i = getDoubleValueFromAttribute(xmlElement, "i2");
			Complex no2 = new Complex(r, i);
			QuBit quBit = new QuBit(no1, no2);
			String name = getRequiredAttribute(xmlElement, "name");
			qubitList.add(new Pair(quBit, name));
		} else if (text.equalsIgnoreCase(IGate.TYPE)) {
			IGate gate = new GateFactory().getGate(GateType.valueOf(getRequiredAttribute(xmlElement, "type")));
			String name = getRequiredAttribute("name");
			gateList.add(new Pair(gate, name));
		}
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
			QuBit qusimBit = (QuBit) qubitList.get(index).getObject();
			Element xmlQuBit = xmlElement.getOwnerDocument().createElement(QuBit.TYPE);
			xmlQuBit.setAttribute("r1", qusimBit.getQubit()[0].getRealString());
			xmlQuBit.setAttribute("i1", qusimBit.getQubit()[0].getImaginaryString());
			xmlQuBit.setAttribute("r2", qusimBit.getQubit()[1].getRealString());
			xmlQuBit.setAttribute("i2", qusimBit.getQubit()[1].getImaginaryString());
			xmlQuBit.setAttribute("index", Integer.toString(index));
			xmlQuBit.setAttribute("name", qubitList.get(index).getName());
			node.appendChild(xmlQuBit);
		}

		for (int index = 0; index < gateList.size(); index++) {
			Pair entry = gateList.get(index);
			Element xmlGate = xmlElement.getOwnerDocument().createElement(IGate.TYPE);
			xmlGate.setAttribute("type", ((IGate) entry.getObject()).toString());
			xmlGate.setAttribute("name", entry.getName());
			xmlGate.setAttribute("index", Integer.toString(index));
			node.appendChild(xmlGate);
		}

		return xmlElement;
	}

	@Override
	public QuBit[] perform() throws Exception {
		for (Pair pair : gateList) {
			IGate gate = (IGate) pair.getObject();
			String name = pair.getName();
			// qubitList = gate.applyGate(inputQubit, targetPosition,
			// conditions, noOfEntangledQubits);
		}
		return (QuBit[]) qubitList.toArray();
	}

	public void addQuBit(QuBit quBit, String name) {
		qubitList.add(new Pair(quBit, name));
	}

	public void addGate(IGate gate, String name) {
		gateList.add(new Pair(gate, name));
	}

	public void removeGate(int index) {
		gateList.remove(index);
	}

	public void removeGate(IGate gate) {
		for (Pair pair : gateList) {
			if (((IGate) pair.getObject()).equals(gate)) {
				gateList.remove(pair);
				return;
			}
		}
	}

	public void removeQuBit(int index) {
		qubitList.remove(index);
	}

	public void removeQuBit(QuBit quBit) {
		for (Pair pair : gateList) {
			if (((QuBit) pair.getObject()).equals(quBit)) {
				qubitList.remove(pair);
				return;
			}
		}
	}

	@Override
	public List<IQSElement> getGenList() {
		return null;
	}

}