package de.qsim.core.model.gate;

import java.util.List;

import de.qsim.core.model.IElement;
import de.qsim.core.model.Project;
import de.qsim.core.model.qubit.QuBit;

public interface IGate extends IElement {
	public static String TYPE = "gate";
	public List<QuBit> applyGate(List<QuBit> inputQubit) throws Exception;
	public String getDescription();
	public List<Integer> getTargetPosition();
	public void setTargetPosition(List<Integer> targetPosition);
	public List<Integer> getConditions();
	public void setConditions(List<Integer> conditions);
	public int getNoOfEntangledQubits();
	public void setNoOfEntangledQubits(int noOfEntangledQubits);
	public void setParent(IElement parent);
	public void setProject(Project project);
	public GateType getGateType();
}
