package de.qsim.core.model.exception;

public class NodeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4058497386840281202L;

	public NodeException() {
	}

	public NodeException(String message) {
		super(message);
	}

	public NodeException(Throwable cause) {
		super(cause);
	}

	public NodeException(String message, Throwable cause) {
		super(message, cause);
	}

}
