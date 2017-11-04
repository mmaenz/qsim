package de.qsim.core.model.gate;

import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.model.qubit.QuBit;

public strictfp class IdentityGate extends AbstractGate implements IGate {

	public IdentityGate(Element element, Project project, IElement parent) throws Exception {
		super(element, project, parent, GateType.IdentityGate);
	}

	public IdentityGate(String name) throws Exception {
		super(name, null, null, GateType.IdentityGate);
	}

	public IdentityGate(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent, GateType.IdentityGate);
	}

	@Override
	public List<QuBit> applyGate(List<QuBit> inputQubit) throws Exception {
		super.applyGate(inputQubit);
		return inputQubit;
	}

	@Override
	public String getDescription() {
		return getType().getDescription();
	}

	@Override
	public GateType getGateType() {
		return getType();
	}
	
	@Override
	public List<QuBit> step() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}