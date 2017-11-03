package de.qsim.core.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.qubit.QuBit;

public class Register extends AbstractElement {
	public static String TYPE = "register";

	public Register(Element element, Project project, IElement parent) throws Exception {
		super(element, project, null);
		loadNode();
		loadChildren();
	}

	public Register(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent);
	}
	
	@Override
	public List<QuBit> perform() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Rail createRail(String name) throws Exception {
		IElement rail = new Rail(name, getProject(), this);
		getGenList().add(rail);
		return (Rail)rail;
	}

	public void removeRail(int index) {
		getGenList().remove(index);
	}
	
	public void removeRail(Rail rail) {
		getGenList().remove(rail);
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
}