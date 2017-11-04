package de.qsim.core.model.gate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.model.qubit.QuBit;
import de.qsim.core.utils.Complex;

public strictfp class ZGate extends AbstractGate implements IGate {

	public ZGate(Element element, Project project, IElement parent) throws Exception {
		super(element, project, parent, GateType.ZGate);
	}

	public ZGate(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent, GateType.ZGate);
	}

	public ZGate(String name) throws Exception {
		super(name, null, null, GateType.ZGate);
	}

	@Override
	public List<QuBit> applyGate(List<QuBit> inputQubit) throws Exception {
		super.applyGate(inputQubit);
		int mask = 0;
		int newPosition = 0;
		Complex[] states = inputQubit.get(0).getComplex();
		String name = inputQubit.get(0).getName();
		int[] markedStates = new int[states.length];
		for (int i : getTargetPosition()) {
			Arrays.fill(markedStates, 0);
			mask = (1 << (getNoOfEntangledQubits() - 1 - i));
			for (int j = 0; j < states.length; j++) {
				if (markedStates[j] == 0) {
					newPosition = j ^ mask;
					states[j] = Complex.multiply(states[j], new Complex(1.0, 0.0));
					states[newPosition] = Complex.multiply(states[newPosition], new Complex(-1.0, 0.0));
					markedStates[j] = 1;
					markedStates[newPosition] = 1;
				}
				continue;

			}
			mask = 0;
		}
		List<QuBit> ret = new ArrayList<>();
		ret.add(new QuBit(name, states));
		return ret;
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
