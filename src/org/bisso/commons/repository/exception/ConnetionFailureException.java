package org.bisso.commons.repository.exception;

public class ConnetionFailureException extends InfrastructureException {

	public ConnetionFailureException() {
		super();
	}

	public ConnetionFailureException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConnetionFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnetionFailureException(String message) {
		super(message);
	}

	public ConnetionFailureException(Throwable cause) {
		super(cause);
	}

	
	
}
