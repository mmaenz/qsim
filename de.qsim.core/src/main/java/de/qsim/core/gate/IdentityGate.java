package de.qsim.core.gate;

import de.qsim.core.qubit.QuBit;

public class IdentityGate implements IGate {

	@Override
	public String getDescription() {
		return GateType.IdentityGate.getDescription();
	}

	@Override
	public QuBit[] applyGate(QuBit[] inputQubit, int[] targetPosition, int[] conditions, int noOfEntangledQubits) {
		return inputQubit;
	}
	
	@Override
	public String toString() {
		return "IdentityGate";
	}

}
