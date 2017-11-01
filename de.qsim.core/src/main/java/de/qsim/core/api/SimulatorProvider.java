package de.qsim.core.api;

import de.qsim.core.simulator.Simulator;

public class SimulatorProvider {
	private static Simulator instance = null;
	
	private static Simulator createSimulator(String name) {
		instance = new Simulator(name);
		return instance;
	}

	public static Simulator getSimulator(String name) {
		if (instance == null) {
			return createSimulator(name);
		} else {
			return instance;
		}
	}
	
}
