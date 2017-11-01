package de.qsim.core.api;

import de.qsim.core.simulator.source.engine.Jython;

public class JythonProvider {
	private static Jython instance;
	
	public static Jython getEngine() {
		if (instance == null) {
			instance = new Jython();
		}
		return instance;
	}
}
