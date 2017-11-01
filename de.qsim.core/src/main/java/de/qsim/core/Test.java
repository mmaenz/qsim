package de.qsim.core;

import de.qsim.core.api.AbstractGateFactory;
import de.qsim.core.api.GateFactory;
import de.qsim.core.api.SimulatorProvider;
import de.qsim.core.gate.GateType;
import de.qsim.core.qubit.QuBit;
import de.qsim.core.simulator.Simulator;
import de.qsim.core.simulator.model.SimulatorProject;
import de.qsim.core.simulator.model.SimulatorRail;
import de.qsim.core.simulator.model.SimulatorRegister;
import de.qsim.core.utils.Complex;

public class Test {
	protected AbstractGateFactory gateFactory = GateFactory.getGateFactory();
	
	public void doWork() {
		gateFactory.getGateTypes().forEach(gate -> {
			System.out.println(
					String.format("%s: %s", gate.toString(), gate.getDescription()));
		});
		
		Simulator sim = SimulatorProvider.getSimulator("TestSim");
		SimulatorProject proj = sim.getProject();
		SimulatorRegister reg = proj.addRegister("Neues Register");
		SimulatorRail rail = reg.addRail("testrail");
		rail.addQuBit(new QuBit(new Complex(15.25, 0.123), new Complex(20.25, 123.00)));
		rail.addGate(gateFactory.getGate(GateType.IdentityGate));
		sim.saveProjectToFile("/Users/mmaenz/quantum.xml", "This is just a test source!");
		System.out.println("Done");
	}
	
	public Test() {
		System.out.println("Available gates:");
	}
	
	public static void main(String[] args) {
		new Test().doWork();
	}

}