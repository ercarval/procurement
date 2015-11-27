package org.bisso.commons.repository.exception;

public class InfrastructureException extends Exception {

	private static final long serialVersionUID = -3967400613309495261L;

	public InfrastructureException() {
		super();
	}

	public InfrastructureException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InfrastructureException(String message, Throwable cause) {
		super(message, cause);
	}

	public InfrastructureException(String message) {
		super(message);
	}

	public InfrastructureException(Throwable cause) {
		super(cause);
	}

}
