package com.capco.trainingmanagement.microservice.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationFailureException extends BaseException {

	private static final long serialVersionUID = 1L;

	private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

	public ValidationFailureException(String message, HttpStatus httpStatus) {

		super(message, httpStatus);
	}

	public HttpStatus getErrorMessageCode() {
		return httpStatus;
	}

}
