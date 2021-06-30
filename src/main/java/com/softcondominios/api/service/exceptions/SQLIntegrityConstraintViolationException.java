package com.softcondominios.api.service.exceptions;

public class SQLIntegrityConstraintViolationException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public SQLIntegrityConstraintViolationException(String msg) {
		super(msg);
	}
	public SQLIntegrityConstraintViolationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
