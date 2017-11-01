package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.qubit.QuBit;

public class QSRegister extends AbstractQSElement {
	public static String TYPE = "register";
	private List<IQSElement> railList;
	private String name;
	private IQSElement parent;

	public QSRegister(String name, IQSElement parent) {
		super();
		railList = new ArrayList<>();
		this.name = name;
		this.parent = parent;
	}
	
	public QSRegister(Element element, IQSElement parent) throws Exception {
		super(element);
		railList = new ArrayList<>();
		this.parent = parent;
		loadNode();
		loadChildren();
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

	public QSRail addRail(String name) {
		QSRail rail = new QSRail(name, this);
		railList.add(rail);
		return rail;
	}
	
	public void removeRail(int index) {
		railList.remove(index);
	}
	
	public void removeRail(QSRail rail) {
		railList.remove(rail);
	}

	@Override
	public Element saveElement(Element xmlElement) {
		Element node = xmlElement.getOwnerDocument().createElement(TYPE);
		node.setAttribute("name", name);
		xmlElement.appendChild(node);
		for (IQSElement simElement : railList) {
			simElement.saveElement(node);
		}
		return xmlElement;
	}


	@Override
	public List<IQSElement> getGenList() {
		return railList;
	}

}
