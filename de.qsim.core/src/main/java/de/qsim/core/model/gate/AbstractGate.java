package de.qsim.core.model.gate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Element;

import de.qsim.core.model.AbstractElement;
import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;

public abstract strictfp class AbstractGate extends AbstractElement implements IElement {
	public static String typeTargetPosition = "targetPosition";
	public static String typeConditions = "conditions";
	public static String typeNoEntangled = "noEntangled";

	private List<Integer> targetPosition = new ArrayList<>();
	private List<Integer> conditions = new ArrayList<>();
	private int noOfEntangledQubits = 0;
	private IElement parent;
	private Project project;
	private String type;

	public AbstractGate(Element element, Project project, IElement parent, String type) throws Exception {
		super(element, project, parent);
		this.type = type;
		loadNode();
		loadChildren();
	}

	public AbstractGate(String name, Project project, IElement parent, String type) throws Exception {
		super(name, project, parent);
		this.type = type;
	}

	private List<Integer> getValueList(String values) {
		List<Integer> vl = new ArrayList<>();
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(values);
		while (m.find()) {
			vl.add(Integer.parseInt(m.group()));
		}
		return vl;
	}

	protected void loadChildren(Element element) throws Exception {
		String nodeName = element.getNodeName();
		if (nodeName.equalsIgnoreCase(typeTargetPosition)) {
			targetPosition = getValueList(element.getTextContent());
		} else if (nodeName.equalsIgnoreCase(typeConditions)) {
			conditions = getValueList(element.getTextContent());
		} else if (nodeName.equalsIgnoreCase(typeNoEntangled)) {
			noOfEntangledQubits = Integer.parseInt(element.getTextContent());
		}
	}

	@Override
	public Element saveElement(Element xmlParent) {
		Element node = xmlParent.getOwnerDocument().createElement(IGate.TYPE);
		node.setAttribute("name", this.getName());
		node.setAttribute("type", this.type);
		Element target = xmlParent.getOwnerDocument().createElement(typeTargetPosition);
		target.setTextContent(targetPosition.toString());
		Element cond = xmlParent.getOwnerDocument().createElement(typeConditions);
		cond.setTextContent(conditions.toString());
		Element noEntangled = xmlParent.getOwnerDocument().createElement(typeNoEntangled);
		noEntangled.setTextContent(Integer.toString(noOfEntangledQubits));
		node.appendChild(target);
		node.appendChild(cond);
		node.appendChild(noEntangled);
		xmlParent.appendChild(node);
		return xmlParent;
	}

	public List<Integer> getTargetPosition() {
		return targetPosition;
	}

	public void setTargetPosition(List<Integer> targetPosition) {
		this.targetPosition = targetPosition;
	}

	public List<Integer> getConditions() {
		return conditions;
	}

	public void setConditions(List<Integer> conditions) {
		this.conditions = conditions;
	}

	public int getNoOfEntangledQubits() {
		return noOfEntangledQubits;
	}

	public void setNoOfEntangledQubits(int noOfEntangledQubits) {
		this.noOfEntangledQubits = noOfEntangledQubits;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getType() {
		return type;
	}

}
