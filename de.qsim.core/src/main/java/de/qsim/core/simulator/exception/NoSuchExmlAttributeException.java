package de.qsim.core.simulator.exception;

public class NoSuchExmlAttributeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6229275416461613896L;

	public NoSuchExmlAttributeException() {
	}

	public NoSuchExmlAttributeException(String message) {
		super(message);
	}

	public NoSuchExmlAttributeException(Throwable cause) {
		super(cause);
	}

	public NoSuchExmlAttributeException(String message, Throwable cause) {
		super(message, cause);
	}

}
