package com.capco.trainingmanagement.microservice.exceptions;

import org.springframework.http.HttpStatus;

public class BaseException extends Exception{

	private static final long serialVersionUID = 1L;
	private final int code;

	private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

	public BaseException(int code) {
		super();
		this.code = code;
	
	}

	public int getCode() {
		return code;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
