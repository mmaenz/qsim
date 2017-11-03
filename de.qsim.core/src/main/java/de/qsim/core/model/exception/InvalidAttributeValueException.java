package de.qsim.core.model.exception;

public class InvalidAttributeValueException extends Exception {
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
