package de.qsim.core.model.exception;

public class AbstractNodeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3000858201749280660L;

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
