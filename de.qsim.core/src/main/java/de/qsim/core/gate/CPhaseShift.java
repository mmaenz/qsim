package de.qsim.core.gate;

import de.qsim.core.qubit.QuBit;
import de.qsim.core.utils.Complex;

public class CPhaseShift implements IGate {

	@Override
	public QuBit[] applyGate(QuBit[] inputQubit, int[] targetPosition,
			int[] conditions, int noOfEntangledQubits) {
		int mask = 0;
		int new_position = 0;

		Complex[] states = inputQubit[0].getQubit();
		for (int i : conditions) {
			mask |= (1 << (noOfEntangledQubits - 1 - i));
		}
		mask |= (1 << (noOfEntangledQubits - targetPosition[0] - 1));
		new_position = mask | 0x01;
		states[mask] = Complex.multiply(states[mask], new Complex(
				-1.0, 0.0));

		states[new_position] = Complex.multiply(states[new_position],
				new Complex(-1.0, 0.0));

		QuBit ret[] = {new QuBit(states)}; 
		return ret;
}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
