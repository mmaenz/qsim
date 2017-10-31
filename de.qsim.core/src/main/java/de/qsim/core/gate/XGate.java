package de.qsim.core.gate;

import java.util.Arrays;

import de.qsim.core.qubit.QuBit;
import de.qsim.core.utils.Complex;

public class XGate implements IGate {

	@Override
	public QuBit applyGate(QuBit inputQubit, int[] targetPosition,
			int[] conditions, int noOfEntangledQubits) {
		int mask = 0;
		int newPosition = 0;
		Complex[] states = inputQubit.getQubit();
		Complex bufferState;
		int[] markedStates = new int[states.length];
		for (int i : targetPosition) {
			Arrays.fill(markedStates, 0);
			mask = (1 << (noOfEntangledQubits - 1 - i));
			for (int j = 0; j < states.length; j++) {
				if (markedStates[j] == 0) {
					bufferState = states[j];
					newPosition = j ^ mask;
					states[j] = states[newPosition];
					states[newPosition] = bufferState;
					markedStates[j] = 1;
					markedStates[newPosition] = 1;
				}
				continue;
			}
			mask = 0;
		}
		return new QuBit(states);

}

	@Override
	public String getDescription() {
		return "XGate";
	}

}
