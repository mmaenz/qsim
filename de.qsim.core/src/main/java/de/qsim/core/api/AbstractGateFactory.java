package de.qsim.core.api;

import java.util.stream.Stream;

import de.qsim.core.gate.GateType;
import de.qsim.core.gate.IGate;

public abstract class AbstractGateFactory {
	public abstract Stream<GateType> getGateTypes();
	public abstract IGate getGate(GateType id);
}
