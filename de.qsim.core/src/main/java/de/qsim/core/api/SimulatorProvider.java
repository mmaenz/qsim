package de.qsim.core.api;

import de.qsim.core.simulator.QuSimulator;

public class SimulatorProvider {
	private static QuSimulator instance = null;
	
	private static QuSimulator createSimulator() {
		instance = new QuSimulator();
		return instance;
	}

	public static QuSimulator getBrowser() {
		if (instance == null) {
			return createSimulator();
		} else {
			return instance;
		}
	}
	
}
