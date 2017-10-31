package de.qsim.core.gate;

import java.util.Arrays;

import de.qsim.core.qubit.QuBit;
import de.qsim.core.utils.Complex;

public class ZGate implements IGate {

	@Override
	public QuBit applyGate(QuBit inputQubit, int[] targetPosition,
			int[] conditions, int noOfEntangledQubits) {
		int mask = 0;
		int newPosition = 0;
		Complex[] states = inputQubit.getQubit();
		int[] markedStates = new int[states.length];
		for (int i : targetPosition) {
			Arrays.fill(markedStates, 0);
			mask = (1 << (noOfEntangledQubits - 1 - i));
			for (int j = 0; j < states.length; j++) {
				if (markedStates[j] == 0) {
					newPosition = j ^ mask;
					states[j] = Complex.multiply(states[j],
							new Complex(1.0, 0.0));
					states[newPosition] = Complex.multiply(
							states[newPosition], new Complex(-1.0, 0.0));
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
		// TODO Auto-generated method stub
		return null;
	}

}
