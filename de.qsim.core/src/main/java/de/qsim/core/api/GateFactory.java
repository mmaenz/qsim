package de.qsim.core.api;

import de.qsim.core.gate.EmptyGate;
import de.qsim.core.gate.GateType;
import de.qsim.core.gate.IGate;

public class GateFactory extends AbstractGateFactory {
	public IGate getGate(GateType id) {
		IGate gate = null;
		
		switch (id) {
		case EmptyGate:
			gate = new EmptyGate();
			break;
		}
		
		return gate;
}}
