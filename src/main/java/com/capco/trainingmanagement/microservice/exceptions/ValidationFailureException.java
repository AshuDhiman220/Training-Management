package com.capco.trainingmanagement.microservice.exceptions;


public class ValidationFailureException extends BaseException {

	
	private static final long serialVersionUID = 1L;

	public ValidationFailureException(int code) {

		super(code);
	}

	

}
