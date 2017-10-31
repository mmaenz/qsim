package de.qsim.core.gate;

import de.qsim.core.qubit.QuBit;

public class EmptyGate implements IGate {

	@Override
	public String getDescription() {
		return "EmptyGate";
	}

	@Override
	public QuBit applyGate(QuBit inputQubit, int[] targetPosition, int[] conditions, int noOfEntangledQubits) {
		return inputQubit;
	}
	
}
