package com.capco.trainingmanagement.microservice.config;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.capco.trainingmanagement.microservice.constants.LoginAndRegistrationConstants;
import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;
import com.capco.trainingmanagement.microservice.model.ApiResponse;
import com.capco.trainingmanagement.microservice.model.Status;
import com.fasterxml.jackson.core.JsonParseException;


@RestControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(value = { UnknownHostException.class, IllegalArgumentException.class, NoSuchMethodException.class,
			JsonParseException.class, InvocationTargetException.class, InvocationTargetException.class, Exception.class,
			IllegalStateException.class })
	public final ResponseEntity<Status> handleUnknownHostExceptions(Exception ex, WebRequest request) {
		Status errorDetails = new Status(HttpStatus.BAD_REQUEST.value() , ex.getLocalizedMessage(),
				request.getDescription(false));
		ex.printStackTrace();
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidationFailureException.class)
	public final ResponseEntity<Status> handlePaymentExceptions(ValidationFailureException e, WebRequest request)
			throws IOException {


		Status status = new Status();
		
		status.setCode(e.getCode());
		status.setMessage(getErrorMessage(e.getCode()+""));
		status.setDetails(request.getDescription(false));
		e.printStackTrace();


		return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
	}
	
	public String getErrorMessage(String errorCode) throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("error_messages.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties.getProperty(errorCode);
	}

}
