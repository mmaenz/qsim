package de.qsim.core.gate;

import java.util.stream.Stream;

public abstract class AbstractGateFactory {
	public abstract Stream<GateType> getGateTypes();
	public abstract IGate getGate(GateType id);
}