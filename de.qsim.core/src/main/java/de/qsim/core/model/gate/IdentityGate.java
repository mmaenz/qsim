package de.qsim.core.model.gate;

import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.model.qubit.QuBit;

public strictfp class IdentityGate extends AbstractGate implements IGate {

	public IdentityGate(Element element, Project project, IElement parent) throws Exception {
		super(element, project, parent, GateType.IdentityGate.toString());
	}

	public IdentityGate(String name) throws Exception {
		super(name, null, null, GateType.IdentityGate.toString());
	}

	public IdentityGate(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent, GateType.IdentityGate.toString());
	}
	
	@Override
	public String getDescription() {
		return GateType.IdentityGate.getDescription();
	}

	@Override
	public List<QuBit> applyGate(List<QuBit> inputQubit) {
		return inputQubit;
	}
	
	@Override
	public String toString() {
		return getType();
	}

	@Override
	public List<QuBit> step() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}