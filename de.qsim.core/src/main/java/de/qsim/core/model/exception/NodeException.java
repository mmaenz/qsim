package de.qsim.core.model.exception;

public class NodeException extends Exception {
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
