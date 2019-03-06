package com.capco.trainingmanagement.microservice.service;

import org.springframework.http.ResponseEntity;

import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;
import com.capco.trainingmanagement.microservice.model.Employee;
import com.capco.trainingmanagement.microservice.model.ResponseObject;
import com.capco.trainingmanagement.microservice.model.SecurityQa;



public interface RegisterService {

public ResponseEntity<ResponseObject> registerUser(Employee emp) throws ValidationFailureException, Exception;	
//public ResponseEntity<ResponseObject> verfiySecurityQA(SecurityQa sqa) throws ValidationFailureException, Exception;
}
