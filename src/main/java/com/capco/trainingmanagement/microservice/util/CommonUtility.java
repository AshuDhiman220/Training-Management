package com.capco.trainingmanagement.microservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capco.trainingmanagement.microservice.model.ResponseObject;
import com.capco.trainingmanagement.microservice.model.Status;

public class CommonUtility {
	
	public static ResponseEntity<ResponseObject> responseMessage(int code, String message, HttpStatus httpStatus) {
		 Status status = new Status();
		ResponseObject response = new ResponseObject();
		status.setCode(200);
		status.setMessage(message);
		response.setStatus(status);
		return new ResponseEntity<>(response, httpStatus);
	}

}
