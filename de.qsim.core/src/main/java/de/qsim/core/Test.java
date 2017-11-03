package de.qsim.core;

import java.util.ArrayList;
import java.util.List;

import de.qsim.core.api.JythonProvider;
import de.qsim.core.api.SimulatorProvider;
import de.qsim.core.model.Project;
import de.qsim.core.model.Rail;
import de.qsim.core.model.Register;
import de.qsim.core.model.gate.GateFactory;
import de.qsim.core.model.gate.GateType;
import de.qsim.core.model.gate.IGate;
import de.qsim.core.model.qubit.QuBit;
import de.qsim.core.simulator.Simulator;
import de.qsim.core.simulator.source.engine.Jython;
import de.qsim.core.utils.Complex;

public class Test {
	
	private void doSave() throws Exception {
		System.out.println("Available gates:");
		GateFactory gf = GateFactory.getGateFactory();
		gf.getGateTypes().forEach(gate -> {
			System.out.println(
					String.format("%s: %s", gate.toString(), gate.getDescription()));
		});
		
		Simulator sim = SimulatorProvider.getSimulator();
		Project proj = sim.createProject();
		Register reg = proj.createRegister("Neues Register");
		Rail rail = reg.createRail("New Rail here");
		
		QuBit bit = new QuBit("MyQuBit", new Complex(15.25, 0.123), new Complex(20.25, 123.00));
		
		rail.addQuBit(bit);
		IGate gate = gf.createGate(GateType.IdentityGate, "Ein neues Gatter");
		
		List<Integer> test = new ArrayList<>();
		test.add(15);
		test.add(123);
		test.add(1);
		gate.setConditions(test);
		gate.setTargetPosition(test);
		gate.setNoOfEntangledQubits(5);
		
		rail.addGate(gate);
		
		sim.saveProjectToFile("/Users/mmaenz/quantum.xml", "This is just a test source!");
		System.out.println("Done");
	}
	
	private void doLoad() {
		Simulator sim = SimulatorProvider.getSimulator();
		sim.loadProjectFromFile("/Users/mmaenz/quantum.xml");
		sim.saveProjectToFile("/Users/mmaenz/quantum.xml", "This is just a test source!");
	}

	private void doJython() {
		Jython jy = JythonProvider.getEngine();
	}

	public Test() {
		System.out.println("QuantumSimulator");
	}
	
	public static void main(String[] args) {
		try {
		new Test().doSave();
		new Test().doLoad();
		new Test().doJython();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
