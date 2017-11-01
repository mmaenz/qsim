package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.qubit.QuBit;

public class QuSimProject extends AbstractElement {
	public static final String TYPE = "project";
	private final List<IQuSimElement> genList;
	
	public QuSimProject(Element element) throws Exception {
		super(element);
		genList = new ArrayList<>();
		loadNode();
		loadChildren();
	}

	public QuSimProject() {
		super();
		genList = new ArrayList<>();
	}
	
	@Override
	protected void loadChildren(Element child) throws Exception {
		final String nodeName = child.getNodeName();
//		if (nodeName.equalsIgnoreCase(SimplePage.SIMPLE_TYPE)) {
//			final SimplePage page = new SimplePage(child, this);
//			genList.add(page);
//		}
	}

	@Override
	public QuBit[] perform() throws Exception {
		for (final IQuSimElement element : genList) {
			element.perform();
		}
		return null;
	}

	public QuSimRegister addRegister(String name) {
		QuSimRegister register = new QuSimRegister();
		genList.add(register);
		return register;
	}
	
	public void removeRegister(QuSimRegister register) {
		genList.remove(register);
	}

	public void removeRegister(int index) {
		genList.remove(index);
	}
	
	@Override
	public Element saveElement(Element element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadElement(Element element) {
		// TODO Auto-generated method stub
	}

}