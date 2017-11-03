package de.qsim.core.api;

import de.qsim.core.simulator.Simulator;

public class SimulatorProvider {
	private static Simulator instance = null;

	public static Simulator getSimulator() {
		if (instance == null) {
			instance = new Simulator();
		}
		return instance;
	}

}
