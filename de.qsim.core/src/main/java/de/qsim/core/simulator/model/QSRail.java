package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.api.GateFactory;
import de.qsim.core.gate.GateType;
import de.qsim.core.gate.IGate;
import de.qsim.core.qubit.QuBit;
import de.qsim.core.utils.Complex;
import de.qsim.core.utils.XML;

public class QSRail extends AbstractQSElement {
	public static String TYPE = "rail";
	private List<QuBit> qubitList;
	private List<IGate> gateList;
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
			qubitList.add(quBit);
		} else if (text.equalsIgnoreCase(IGate.TYPE)) {
			IGate gate = new GateFactory().getGate(GateType.valueOf(getRequiredAttribute(xmlElement, "name")));
			gateList.add(gate);
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
	public List<IQSElement> getGenList() {
		return null;
	}
	
}