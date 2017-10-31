package de.qsim.core.gate;

public enum GateType {
	HGate,
	/**
	 * Pauli-X Gate
	 */
	XGate,
	/**
	 * Pauli-Y Gate
	 */
	YGate,
	/**
	 * Pauli-Z Gate
	 */
	ZGate,
	/**
	 * CNOT Gate
	 */
	CNotGate,
	/**
	 * Controlled Phase Shift
	 */
	CPhaseShift,
	/**
	 * Identity gate
	 */
	IdentityGate
}