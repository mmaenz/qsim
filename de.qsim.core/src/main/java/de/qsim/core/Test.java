package de.qsim.core;

import de.qsim.core.api.GateProvider;
import de.qsim.core.api.JythonProvider;
import de.qsim.core.api.SimulatorProvider;
import de.qsim.core.gate.AbstractGateFactory;
import de.qsim.core.gate.GateType;
import de.qsim.core.gate.IGate;
import de.qsim.core.qubit.QuBit;
import de.qsim.core.simulator.Simulator;
import de.qsim.core.simulator.model.QSProject;
import de.qsim.core.simulator.model.QSRail;
import de.qsim.core.simulator.model.QSRegister;
import de.qsim.core.simulator.source.engine.Jython;
import de.qsim.core.utils.Complex;

public class Test {
	
	private void doSave() {
		System.out.println("Available gates:");
		AbstractGateFactory gf = GateProvider.getFactory();
		gf.getGateTypes().forEach(gate -> {
			System.out.println(
					String.format("%s: %s", gate.toString(), gate.getDescription()));
		});
		
		Simulator sim = SimulatorProvider.getSimulator("TestSim");
		QSProject proj = sim.getProject();
		QSRegister reg = proj.addRegister("Neues Register");
		QSRail rail = reg.addRail("testrail");
		rail.addQuBit(new QuBit(new Complex(15.25, 0.123), new Complex(20.25, 123.00)), "XYZ");
		IGate gate = gf.getGate(GateType.IdentityGate);
		rail.addGate(gate, gate.getDescription());
		sim.saveProjectToFile("/Users/mmaenz/quantum.xml", "This is just a test source!");
		System.out.println("Done");
	}
	
	private void doLoad() {
		Simulator sim = SimulatorProvider.getSimulator();
		sim.loadProjectFromFile("/Users/mmaenz/quantum.xml");
	}

	private void doJython() {
		Jython jy = JythonProvider.getEngine();
	}

	public Test() {
		System.out.println("QuantumSimulator");
	}
	
	public static void main(String[] args) {
		new Test().doSave();
		new Test().doLoad();
		new Test().doJython();
	}
}
