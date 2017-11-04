package de.qsim.core.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.qubit.QuBit;

public class Register extends AbstractElement {
	public static String TYPE = "register";
	private List<IElement> railList;

	public Register(Element element, Project project, IElement parent) throws Exception {
		super(element, project, null);
		railList = new ArrayList<>();
		loadNode();
		loadChildren();
	}

	public Register(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent);
		railList = new ArrayList<>();
	}

	public Rail createRail(String name) throws Exception {
		IElement rail = new Rail(name, getProject(), this);
		getGenList().add(rail);
		railList.add(rail);
		return (Rail) rail;
	}

	@Override
	protected void loadChildren(Element xmlElement) throws Exception {
		final String nodeName = xmlElement.getNodeName();
		if (nodeName.equalsIgnoreCase(Rail.TYPE)) {
			final Rail instance = new Rail(xmlElement, getProject(), this);
			getGenList().add(instance);
			railList.add(instance);
		}
	}

	public void removeRail(int index) {
		railList.remove(getGenList().remove(index));
	}

	public void removeRail(Rail rail) {
		getGenList().remove(rail);
		railList.remove(rail);
	}

	public List<Rail> getRailList() {
		List<Rail> ret = new ArrayList<>();
		for (IElement rail : railList) {
			ret.add((Rail) rail);
		}
		return ret;
	}

	public Rail getRailByName(String name) {
		for (IElement rail : railList) {
			if (rail.getName().equals(name)) {
				return (Rail) rail;
			}
		}
		return null;
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
	public List<QuBit> step() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}