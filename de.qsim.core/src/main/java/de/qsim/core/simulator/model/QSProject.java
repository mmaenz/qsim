package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.qsim.core.qubit.QuBit;

public class QSProject extends AbstractQSElement {
	public static final String TYPE = "project";
	private final List<IQSElement> genList;
	private String name;
	
	public QSProject(Element element) throws Exception {
		super(element);
		genList = new ArrayList<>();
		loadNode();
		loadChildren();
	}

	public QSProject() {
		super();
		this.genList = new ArrayList<>();
	}
	
	public QSProject(String newProjectName) {
		super();
		this.genList = new ArrayList<>();
		this.name = newProjectName;
	}
	
	@Override
	protected void loadNode() throws Exception {
		this.name = getRequiredAttribute("name");
	}
	
	@Override
	public QuBit[] perform() throws Exception {
		for (final IQSElement element : genList) {
			element.perform();
		}
		return null;
	}

	public QSRegister addRegister(String name) {
		QSRegister register = new QSRegister(name, this);
		genList.add(register);
		return register;
	}
	
	public void removeRegister(QSRegister register) {
		genList.remove(register);
	}

	public void removeRegister(int index) {
		genList.remove(index);
	}
	
	public Element saveElement(Document xmlDoc) {
		Element element = xmlDoc.createElement("project");
		element.setAttribute("name", this.name);
		xmlDoc.appendChild(element);
		for (IQSElement qusimElement : genList) {
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

	@Override
	public List<IQSElement> getGenList() {
		return genList;
	}
}