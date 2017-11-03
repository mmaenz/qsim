package de.qsim.core.model.exception;

public class AbstractNodeException extends Exception {
	public AbstractNodeException() {
	}

	public AbstractNodeException(String message) {
		super(message);
	}

	public AbstractNodeException(Throwable cause) {
		super(cause);
	}

	public AbstractNodeException(String message, Throwable cause) {
		super(message, cause);
	}

}
