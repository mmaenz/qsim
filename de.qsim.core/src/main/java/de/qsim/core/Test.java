package de.qsim.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.qsim.core.api.SimulatorProvider;
import de.qsim.core.model.Project;
import de.qsim.core.model.Rail;
import de.qsim.core.model.Register;
import de.qsim.core.model.gate.GateFactory;
import de.qsim.core.model.gate.GateType;
import de.qsim.core.model.gate.IGate;
import de.qsim.core.model.qubit.QuBit;
import de.qsim.core.simulator.Simulator;
import de.qsim.core.utils.Complex;

public class Test {
	private String fileName;
	
	private void doSave() throws Exception {
		System.out.println("Available gates:");
		GateFactory gf = GateFactory.getGateFactory();
		gf.getGateTypes().forEach(gate -> {
			System.out.println(String.format("%s: %s", gate.toString(), gate.getDescription()));
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
		System.out.println("Saved: Done!");
	}

	private void doLoad() {
		Simulator sim = SimulatorProvider.getSimulator();
		sim.loadProjectFromFile("/Users/mmaenz/quantum.xml");
		System.out.println("Loading: Done!");
	}

	private void doJython() {
		// Jython jy = JythonProvider.getEngine();
	}

	private void doRun() throws Exception {
		System.out.println("Running");
		Simulator sim = SimulatorProvider.getSimulator();
		sim.run();
		System.out.println("End of run");
	}

	public Test() {
		try {
			File file = new File(Test.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			if (file.isFile()) {
				fileName = new File(file.getParent()).getCanonicalPath();
			} else {
				fileName = file.getCanonicalPath();
			}
		} catch (Exception e) {
		}
		fileName = String.format("%s/quantum.xml", fileName);
		System.out.println(fileName);
		System.out.println("QuantumSimulator");
	}

	public static void main(String[] args) {
		Test test = new Test();
		try {
			test.doSave();
			test.doLoad();
			test.doRun();
			// new Test().doJython();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
