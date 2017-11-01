package de.qsim.core.api;

import de.qsim.core.gate.AbstractGateFactory;
import de.qsim.core.gate.GateFactory;

public class GateProvider {
	private static AbstractGateFactory instance;
	
	public static AbstractGateFactory getFactory() {
		if (instance == null) {
			instance = GateFactory.getGateFactory();
		}
		return instance;
	}
}
