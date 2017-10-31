package de.qsim.core.api;

import de.qsim.core.gate.GateType;
import de.qsim.core.gate.IGate;

public abstract class AbstractGateFactory {
	public abstract IGate getGate(GateType id);
}
