package de.qsim.core.model.qubit;

import java.util.Arrays;

import org.w3c.dom.Element;

import de.qsim.core.model.AbstractNode;
import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.utils.Complex;

public abstract strictfp class AbstractQuBit extends AbstractNode implements IElement {
	protected Complex[] qubitVector;
	protected String name;
	protected Project project;
	protected IElement parent;
	
	public AbstractQuBit(Element element, Project project, IElement parent) throws Exception {
		super(element);
		this.parent = parent;
		this.project = project;
		this.qubitVector = new Complex[2];
		loadNode();
	}
	
	public AbstractQuBit(String name, Complex no0, Complex no1) {
		this.qubitVector = new Complex[2];
		qubitVector[0] = no0;
		qubitVector[1] = no1;
		this.setName(name);
	}

	public AbstractQuBit(String name, Complex[] qubitVector) {
		this.qubitVector = Arrays.copyOf(qubitVector, qubitVector.length);
		this.setName(name);
	}

	@Override
	public void loadNode() throws Exception {
		qubitVector[0] = new Complex(Double.parseDouble(getRequiredAttribute("r1")), Double.parseDouble(getRequiredAttribute("i1")));
		qubitVector[1] = new Complex(Double.parseDouble(getRequiredAttribute("r2")), Double.parseDouble(getRequiredAttribute("i2")));
		setName(getRequiredAttribute("name"));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IElement getParent() {
		return parent;
	}

	public void setParent(IElement parent) {
		this.parent = parent;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
}