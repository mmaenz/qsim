package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.qsim.core.simulator.exception.AbstractElementException;
import de.qsim.core.simulator.exception.InvalidAttributeValueException;
import de.qsim.core.simulator.exception.NoSuchExmlAttributeException;

public abstract class AbstractElement implements ISimulatorElement {
	private Element xmlElement;
	//private ISimulatorElement 
	
	public AbstractElement() {
	}

	public AbstractElement(Element element) {
		this();
		setNode(element);
	}

	protected void loadNode() throws Exception {
		new AbstractElementException("No implementation found!");
	}

	protected void loadChildren() throws Exception {
		for (final Iterator<Element> iterator = getChildren().iterator(); iterator.hasNext();) {
			final Element xmlChild = iterator.next();
			loadChildren(xmlChild);
		}
	}

	protected void loadChildren(Element xmlChild) throws Exception {
		throw new InvalidAttributeValueException("No implementation found for 'loadChildren(Element child)' method");
	}

	protected Element saveNode() throws Exception {
		throw new AbstractElementException("No implementation found!");
	}
	
	protected Element saveChildren() throws Exception {
		for (final Iterator<Element> iterator = getChildren().iterator(); iterator.hasNext();) {
			final Element xmlChild = iterator.next();
			saveChildren(xmlChild);
		}
		return this.xmlElement;
	}
	
	protected void saveChildren(Element xmlChild) throws Exception {
		throw new AbstractElementException("No implementation found for 'saveChildren(Element child)' method");
	}
	
	protected void setNode(Element xmlElement) {
		this.xmlElement = xmlElement;
	}

	protected List<Element> getChildren() {
		return getChildren(xmlElement);
	}

	public List<Element> getChildren(Element xmlElement) {
		final List<Element> result = new ArrayList<>();
		for (Node node = xmlElement.getFirstChild(); node != null; node = node.getNextSibling()) {
			if (node instanceof Element) {
				result.add((Element) node);
			}
		}
		return result;
	}

	protected String getRequiredAttribute(Element xmlElement, String name) throws Exception {
		if (xmlElement.hasAttribute(name)) {
			final String attr = xmlElement.getAttribute(name);
			if (attr == null) {
				throw new InvalidAttributeValueException(String.format("Invalid attribute value '%s'", name));
			}
			return attr;
		} else {
			throw new NoSuchExmlAttributeException(String.format("Attribute '%s' not found", name));
		}
	}

	protected boolean hasAttribute(String name) {
		if (xmlElement == null) {
			return false;
		}
		return xmlElement.hasAttribute(name);
	}

	protected boolean hasAttribute(Element xmlElement, String name) {
		return xmlElement.hasAttribute(name);
	}

	protected String getRequiredAttribute(String name) throws Exception {
		return getRequiredAttribute(xmlElement, name);
	}

	protected int getAttributeCount() {
		return xmlElement.getAttributes().getLength();
	}

	protected double getDoubleValueFromAttribute(String name) throws Exception {
		final String attr = getRequiredAttribute(name);
		if (attr.trim().isEmpty()) {
			throw new InvalidAttributeValueException(String.format("Invalid attributevalue '%s'", name));
		}
		final double result = Double.parseDouble(attr.trim());
		return result;
	}

	public ISimulatorElement getParent() {
		return null;
	}

}
