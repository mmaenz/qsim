package de.qsim.core.model.gate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.model.qubit.QuBit;
import de.qsim.core.utils.Complex;

public strictfp class YGate extends AbstractGate implements IGate {

	public YGate(Element element, Project project, IElement parent) throws Exception {
		super(element, project, parent, GateType.YGate);
	}

	public YGate(String name, Project project, IElement parent) throws Exception {
		super(name, project, parent, GateType.YGate);
	}

	public YGate(String name) throws Exception {
		super(name, null, null, GateType.YGate);
	}

	@Override
	public List<QuBit> applyGate(List<QuBit> inputQubit) throws Exception {
		super.applyGate(inputQubit);
		int mask = 0;
		int newPosition = 0;
		Complex[] states = inputQubit.get(0).getComplex();
		String name = inputQubit.get(0).getName();
		Complex bufferState;
		int[] markedStates = new int[states.length];
		for (int i : getTargetPosition()) {
			Arrays.fill(markedStates, 0);
			mask = (1 << (getNoOfEntangledQubits() - 1 - i));
			for (int j = 0; j < states.length; j++) {
				if (markedStates[j] == 0) {
					newPosition = j ^ mask;
					bufferState = states[j];
					states[j] = Complex.multiply(new Complex(0.0, -1.0), states[newPosition]);
					states[newPosition] = Complex.multiply(new Complex(0.0, 1.0), bufferState);
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
