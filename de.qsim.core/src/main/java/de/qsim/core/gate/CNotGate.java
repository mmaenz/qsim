package de.qsim.core.gate;

import de.qsim.core.qubit.QuBit;
import de.qsim.core.utils.Complex;

public class CNotGate implements IGate {
	@Override
	public QuBit[] applyGate(QuBit[] inputQubit, int[] targetPosition,
			int[] conditions, int noOfEntangledQubits) {

		int mask = 0;
		int newPosition = 0;
		Complex[] states = inputQubit[0].getQubit();
		for (int i : conditions) {
			mask |= (1 << (noOfEntangledQubits - 1 - i));
		}
		mask |= (1 << (noOfEntangledQubits - targetPosition[0]));
		newPosition = mask | 0x01;
		Complex state = states[mask];
		states[mask] = states[newPosition];
		states[newPosition] = state;
		QuBit ret[] = {new QuBit(states)}; 
		return ret;
}

	@Override
	public String getDescription() {
		return "CNotGate";
	}
}
