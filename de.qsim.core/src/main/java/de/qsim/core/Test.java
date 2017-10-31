package de.qsim.core;

import de.qsim.core.api.AbstractGateFactory;
import de.qsim.core.api.GateProducer;

public class Test {
	protected AbstractGateFactory gateFactory = GateProducer.getGateFactory();
	
	public void doWork() {
		gateFactory.getGateTypes().forEach(gate -> {
			System.out.println(gate.toString());
		});
	}
	
	public Test() {	
	}
	
	public static void main(String[] args) {
		new Test().doWork();
	}

}