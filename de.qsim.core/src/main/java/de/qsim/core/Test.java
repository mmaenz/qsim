package de.qsim.core;

import de.qsim.core.api.AbstractGateFactory;
import de.qsim.core.api.GateFactory;

public class Test {
	protected AbstractGateFactory gateFactory = GateFactory.getGateFactory();
	
	public void doWork() {
		gateFactory.getGateTypes().forEach(gate -> {
			System.out.println(
					String.format("%s: %s", gate.toString(), gate.getDescription()));
		});
	}
	
	public Test() {	
	}
	
	public static void main(String[] args) {
		new Test().doWork();
	}

}