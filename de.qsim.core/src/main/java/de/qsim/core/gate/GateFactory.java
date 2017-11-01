package de.qsim.core.gate;

import java.util.stream.Stream;

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
