package com.capco.trainingmanagement.microservice.service;


import org.springframework.http.ResponseEntity;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;
import com.capco.trainingmanagement.microservice.model.ResponseObject;
import com.capco.trainingmanagement.microservice.model.SecurityQa;

public interface LoginService {
	
	public EmployeeEntity findOne(String email);
	
	public ResponseEntity<ResponseObject> verfiySecurityQA(SecurityQa sqa) throws ValidationFailureException, Exception;
}
