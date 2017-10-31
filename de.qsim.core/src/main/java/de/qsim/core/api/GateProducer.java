package de.qsim.core.api;

public class GateProducer {
	public static AbstractGateFactory getGateFactory() {
		return new GateFactory();
}
}
