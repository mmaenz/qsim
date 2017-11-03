package de.qsim.core.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.qsim.core.model.qubit.QuBit;

public class Project extends AbstractNode implements IElement {
	public static final String TYPE = "project";
	private final List<IElement> genList;
	private String name;
	
	public Project(Element element) throws Exception {
		super(element);
		genList = new ArrayList<>();
		loadNode();
		loadChildren();
	}

	public Project() {
		genList = new ArrayList<>();
	}
	
	@Override
	protected void loadNode() throws Exception {
		this.name = getRequiredAttribute("name");
	}

	@Override
	protected void loadChildren(Element child) throws Exception {
		final String nodeName = child.getNodeName();
		if (nodeName.equalsIgnoreCase(Register.TYPE)) {
			final Register instance = new Register(child, this, this);
			genList.add(instance);
		}
	}

	
	@Override
	public List<QuBit> perform() throws Exception {
		for (final IElement element : genList) {
			element.perform();
		}
		return null;
	}

	public Register createRegister(String name) throws Exception {
		IElement register = new Register(name, this, this);
		genList.add(register);
		return (Register)register;
	}
	
	public void removeRegister(Register register) {
		genList.remove(register);
	}

	public void removeRegister(int index) {
		genList.remove(index);
	}
	
	public Element saveElement(Document xmlDoc) {
		Element element = xmlDoc.createElement("project");
		element.setAttribute("name", this.name);
		xmlDoc.appendChild(element);
		for (IElement qusimElement : genList) {
			qusimElement.saveElement(element);
		}
		return element;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Element saveElement(Element xmlParent) {
		// TODO Auto-generated method stub
		return null;
	}

}