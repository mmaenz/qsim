package de.qsim.core.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import de.qsim.core.gate.IGate;
import de.qsim.core.qubit.QuBit;

public class QuSimRail extends AbstractElement {
	private List<QuBit> qubitList;
	private List<IGate> gateList;
	
	void QuSimBit() {
		gateList = new ArrayList<>();
		qubitList = new ArrayList<>();
	}
	
	@Override
	public Element saveElement(Element xmlElement) {
		
		return null;
	}

	@Override
	public QuBit[] perform() throws Exception {
		for (IGate gate : gateList) {
			//qubitList = gate.applyGate(inputQubit, targetPosition, conditions, noOfEntangledQubits);
		}
		return (QuBit[])qubitList.toArray();
	}

	public void addQuBit(QuBit quBit) {
		qubitList.add(quBit);
	}
	
	public void addGate(IGate gate) {
		gateList.add(gate);
	}
	
	public void removeGate(int index) {
		gateList.remove(index);
	}

	public void removeGate(IGate gate) {
		gateList.remove(gate);
	}

	public void removeQuBit(int index) {
		qubitList.remove(index);
	}

	public void removeQuBit(QuBit quBit) {
		qubitList.remove(quBit);
	}

	@Override
	public void loadElement(Element xmlElement) {
		// TODO Auto-generated method stub
	}

}