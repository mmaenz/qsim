package de.qsim.core.model.gate;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.model.qubit.QuBit;
import de.qsim.core.utils.Complex;

public class CNotGate extends AbstractGate implements IGate {
	
	public CNotGate(Element element, Project project, IElement parent) throws Exception {
		super(element, project, parent, GateType.CNotGate.toString());
	}

	public CNotGate(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent, GateType.CNotGate.toString());
	}
	
	public CNotGate(String name) throws Exception {
		super(name, null, null, GateType.CNotGate.toString());
	}

	@Override
	public List<QuBit> applyGate(List<QuBit> inputQubit) {
		int mask = 0;
		int newPosition = 0;
		Complex[] states = inputQubit.get(0).getComplex();
		String name = inputQubit.get(0).getName();
		for (int i : getConditions()) {
			mask |= (1 << (getNoOfEntangledQubits() - 1 - i));
		}
		mask |= (1 << (getNoOfEntangledQubits() - getTargetPosition().get(0)));
		newPosition = mask | 0x01;
		Complex state = states[mask];
		states[mask] = states[newPosition];
		states[newPosition] = state;
		List<QuBit> ret = new ArrayList<>();
		ret.add(new QuBit(name, states));
		return ret;
}

	@Override
	public String getDescription() {
		return GateType.CNotGate.getDescription();
	}
	
	@Override
	public String toString() {
		return "CNotGate";
	}
}
