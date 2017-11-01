package de.qsim.core.simulator.exception;

public class AbstractElementException extends Exception {
	public AbstractElementException() {
	}

	public AbstractElementException(String message) {
		super(message);
	}

	public AbstractElementException(Throwable cause) {
		super(cause);
	}

	public AbstractElementException(String message, Throwable cause) {
		super(message, cause);
	}

}
