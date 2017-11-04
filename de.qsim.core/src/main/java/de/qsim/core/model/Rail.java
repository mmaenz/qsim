package de.qsim.core.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.gate.GateFactory;
import de.qsim.core.model.gate.GateType;
import de.qsim.core.model.gate.IGate;
import de.qsim.core.model.qubit.QuBit;

public class Rail extends AbstractElement {
	public static String TYPE = "rail";
	private List<IElement> qubitList;
	private List<IGate> gateList;

	public Rail(Element element, Project project, IElement parent) throws Exception {
		super(element, project, parent);
		gateList = new ArrayList<>();
		qubitList = new ArrayList<>();
		loadNode();
		loadChildren();
	}

	public Rail(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent);
		gateList = new ArrayList<>();
		qubitList = new ArrayList<>();
	}

	@Override
	protected void loadChildren(Element xmlElement) throws Exception {
		final String nodeName = xmlElement.getNodeName();
		if (nodeName.equalsIgnoreCase(QuBit.TYPE)) {
			final QuBit instance = new QuBit(xmlElement, getProject(), this);
			qubitList.add(instance);
			getGenList().add(instance);
		} else if (nodeName.equalsIgnoreCase(IGate.TYPE)) {
			GateFactory gf = GateFactory.getGateFactory();
			String type = getRequiredAttribute(xmlElement, "type");
			IGate gate = gf.createGate(GateType.valueOf(type), xmlElement, getProject(), getParent());
			gateList.add(gate);
			getGenList().add(gate);
		}
	}

	@Override
	public Element saveElement(Element xmlElement) {
		Element node = xmlElement.getOwnerDocument().createElement(TYPE);
		node.setAttribute("name", getName());
		xmlElement.appendChild(node);
		for (IElement simElement : getGenList()) {
			simElement.saveElement(node);
		}
		return xmlElement;
	}

	@Override
	public List<QuBit> perform() throws Exception {
		List<QuBit> quBits = new ArrayList<>();
		System.out.println("Input-QuBits:");
		for (IElement bit : qubitList) {
			quBits.add((QuBit) bit);
			System.out.println(String.format("%s: %s", ((QuBit)bit).getName(), bit.toString()));
		}

		for (IGate gate : gateList) {
			System.out.println(String.format("Apply to %s", gate.toString()));
			quBits = gate.applyGate(quBits);
			System.out.println("Output-QuBits:");
			for (QuBit bit : quBits) {
				System.out.println(String.format("%s: %s", ((QuBit)bit).getName(), bit.toString()));
			}
		}
		return quBits;
	}

	public void addQuBit(QuBit quBit) {
		quBit.setParent(this);
		quBit.setProject(getProject());
		qubitList.add(quBit);
		getGenList().add(quBit);
	}

	public void addGate(IGate gate) {
		gate.setParent(this);
		gate.setProject(getProject());
		gateList.add(gate);
		getGenList().add(gate);
	}

	public boolean removeGate(int index) {
		return getGenList().remove(gateList.remove(index));
	}

	public boolean removeGate(IGate gate) {
		gateList.remove(gate);
		return getGenList().remove(gate);
	}

	public boolean removeQuBit(int index) {
		return getGenList().remove(qubitList.remove(index));
	}

	public boolean removeQuBit(IElement quBit) {
		qubitList.remove(quBit);
		return getGenList().remove(quBit);

	}

	@Override
	public List<QuBit> step() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}