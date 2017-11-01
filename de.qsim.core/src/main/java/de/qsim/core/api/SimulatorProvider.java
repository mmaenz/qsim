package de.qsim.core.api;

import de.qsim.core.simulator.Simulator;

public class SimulatorProvider {
	private static Simulator instance = null;

	public static Simulator getSimulator(String newProjectName) {
		if (instance == null) {
			instance = new Simulator(newProjectName);
		}
		return instance;
	}

	public static Simulator getSimulator() {
		if (instance == null) {
			instance = new Simulator();
		}
		return instance;
	}

}
