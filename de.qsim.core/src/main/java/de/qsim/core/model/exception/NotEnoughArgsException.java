package de.qsim.core.model.exception;

public class NotEnoughArgsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1753674438803707580L;

	public NotEnoughArgsException() {
	}

	public NotEnoughArgsException(String message) {
		super(message);
	}

	public NotEnoughArgsException(Throwable cause) {
		super(cause);
	}

	public NotEnoughArgsException(String message, Throwable cause) {
		super(message, cause);
	}

}
