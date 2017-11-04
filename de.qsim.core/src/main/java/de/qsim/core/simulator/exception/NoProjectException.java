package de.qsim.core.simulator.exception;

public class NoProjectException extends Exception {
	public NoProjectException() {
		super("No project to run!");
	}

	public NoProjectException(String message) {
		super(message);
	}

	public NoProjectException(Throwable cause) {
		super(cause);
	}

	public NoProjectException(String message, Throwable cause) {
		super(message, cause);
	}

}
