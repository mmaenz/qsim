package de.qsim.core.model.gate;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.model.qubit.QuBit;
import de.qsim.core.utils.Complex;

public class CPhaseShift extends AbstractGate implements IGate {

	public CPhaseShift(Element element, Project project, IElement parent) throws Exception {
		super(element, project, parent, GateType.CPhaseShift.toString());
	}

	public CPhaseShift(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent, GateType.CPhaseShift.toString());
	}

	public CPhaseShift(String name) throws Exception {
		super(name, null, null, GateType.CPhaseShift.toString());
	}

	@Override
	public List<QuBit> applyGate(List<QuBit> inputQubit) {
		int mask = 0;
		int new_position = 0;

		Complex[] states = inputQubit.get(0).getComplex();
		String name = inputQubit.get(0).getName();

		for (int i : getConditions()) {
			mask |= (1 << (getNoOfEntangledQubits() - 1 - i));
		}
		mask |= (1 << (getNoOfEntangledQubits() - getTargetPosition().get(0) - 1));
		new_position = mask | 0x01;
		states[mask] = Complex.multiply(states[mask], new Complex(
				-1.0, 0.0));

		states[new_position] = Complex.multiply(states[new_position],
				new Complex(-1.0, 0.0));

		List<QuBit> ret = new ArrayList<>();
		ret.add(new QuBit(name, states));
		return ret;
}

	@Override
	public String getDescription() {
		return GateType.CPhaseShift.getDescription();
	}
	
	@Override
	public String toString() {
		return "CPhaseShift";
	}


}
