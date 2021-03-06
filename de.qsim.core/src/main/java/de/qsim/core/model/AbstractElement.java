package de.qsim.core.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.qsim.core.model.gate.GateFactory;
import de.qsim.core.model.gate.GateType;
import de.qsim.core.model.gate.IGate;
import de.qsim.core.model.qubit.QuBit;

public abstract class AbstractElement extends AbstractNode implements IElement {
	private Project project;
	private final List<IElement> genList;
	private IElement parent;
	protected String name;

	public AbstractElement(Element element, Project project, IElement parent) throws Exception {
		super(element);
		this.project = project;
		this.parent = parent;
		genList = new ArrayList<>();
	}

	public AbstractElement(String name, Project project, IElement parent) throws Exception {
		this.project = project;
		this.parent = parent;
		this.setName(name);
		genList = new ArrayList<>();
	}

	@Override
	protected void loadNode() throws Exception {
		setName(getRequiredAttribute("name"));
	}

	public IElement getParent() {
		return this.parent;
	}

	public void setParent(IElement parent) {
		this.parent = parent;
	}

	public Project getProject() {
		return this.project;
	}

	public List<IElement> getGenList() {
		return genList;
	}

	public Element saveElement(Element xmlParent) {
		return xmlParent;
	}

	@Override
	public List<QuBit> perform() throws Exception {
		for (IElement element : getGenList()) {
			element.perform();
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}