package de.qsim.core.model.exception;

public class InvalidAttributeValueException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3575711172035033915L;

	public InvalidAttributeValueException() {
	}

	public InvalidAttributeValueException(String message) {
		super(message);
	}

	public InvalidAttributeValueException(Throwable cause) {
		super(cause);
	}

	public InvalidAttributeValueException(String message, Throwable cause) {
		super(message, cause);
	}

}
