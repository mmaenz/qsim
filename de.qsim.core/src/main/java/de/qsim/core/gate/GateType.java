package de.qsim.core.gate;

public enum GateType {
	/**
	 * Hadamard Gate
	 */
	HGate("Hadamard gate"),
	/**
	 * Pauli-X Gate
	 */
	XGate("Pauli-X gate"),
	/**
	 * Pauli-Y Gate
	 */
	YGate("Pauli-Y gate"),
	/**
	 * Pauli-Z Gate
	 */
	ZGate("Pauli-Z gate"),
	/**
	 * CNOT Gate
	 */
	CNotGate("Controlled-not gate"),
	/**
	 * Controlled Phase Shift
	 */
	CPhaseShift("CPhase-shift gate"),
	/**
	 * Identity gate
	 */
	IdentityGate("Identity gate");
	
	private final String description;
	
	private GateType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}