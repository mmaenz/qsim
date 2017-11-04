package de.qsim.core.model.gate;

public enum GateType {
	/**
	 * Hadamard Gate
	 */
	HGate(1, "Hadamard gate"),
	/**
	 * Pauli-X Gate
	 */
	XGate(1, "Pauli-X gate"),
	/**
	 * Pauli-Y Gate
	 */
	YGate(1, "Pauli-Y gate"),
	/**
	 * Pauli-Z Gate
	 */
	ZGate(1, "Pauli-Z gate"),
	/**
	 * CNOT Gate
	 */
	CNotGate(1, "Controlled-not gate"),
	/**
	 * Controlled Phase Shift
	 */
	CPhaseShift(1, "CPhase-shift gate"),
	/**
	 * Identity gate
	 */
	IdentityGate(1, "Identity gate");
	
	private final String description;
	private final int noInputs;
	
	private GateType(int noInputs, String description) {
		this.description = description;
		this.noInputs = noInputs;
	}
	
	public int getRequiredInputsNr() {
		return this.noInputs;
	}
	
	public String getDescription() {
		return this.description;
	}
}