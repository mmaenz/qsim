package de.qsim.core.gate;

import java.util.Arrays;

import de.qsim.core.qubit.QuBit;
import de.qsim.core.utils.Complex;

public class YGate implements IGate {

	@Override
	public QuBit[] applyGate(QuBit[] inputQubit, int[] targetPosition, int[] conditions, int noOfEntangledQubits) {
		int mask = 0;
		int newPosition = 0;
		Complex[] states = inputQubit[0].getQubit();
		Complex bufferState;
		int[] markedStates = new int[states.length];
		for (int i : targetPosition) {
			Arrays.fill(markedStates, 0);
			mask = (1 << (noOfEntangledQubits - 1 - i));
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
		QuBit ret[] = { new QuBit(states) };
		return ret;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
