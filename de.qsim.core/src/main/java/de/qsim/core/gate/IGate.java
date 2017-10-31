package de.qsim.core.gate;

import de.qsim.core.qubit.QuBit;

public interface IGate {
	public QuBit applyGate(QuBit inputQubit,int[] targetPosition,int[] conditions,int noOfEntangledQubits);
	public String getDescription();
}
