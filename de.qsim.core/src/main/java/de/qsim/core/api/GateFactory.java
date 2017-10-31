package de.qsim.core.api;

import java.util.stream.Stream;

import de.qsim.core.gate.CNotGate;
import de.qsim.core.gate.CPhaseShift;
import de.qsim.core.gate.IdentityGate;
import de.qsim.core.gate.GateType;
import de.qsim.core.gate.HGate;
import de.qsim.core.gate.IGate;
import de.qsim.core.gate.XGate;
import de.qsim.core.gate.YGate;
import de.qsim.core.gate.ZGate;

public class GateFactory extends AbstractGateFactory {

	@Override
	public IGate getGate(GateType id) {

		switch (id) {
		case HGate:
			return new HGate();
		case XGate:
			return new XGate();
		case YGate:
			return new YGate();
		case ZGate:
			return new ZGate();
		case CNotGate:
			return new CNotGate();
		case CPhaseShift:
			return new CPhaseShift();
		case IdentityGate:
			return new IdentityGate();
		default: return null;
		}
	}

	@Override
	public Stream<GateType> getGateTypes() {
		return Stream.of(GateType.values());
	}
	
	public static AbstractGateFactory getGateFactory() {
		return new GateFactory();
	}
}
