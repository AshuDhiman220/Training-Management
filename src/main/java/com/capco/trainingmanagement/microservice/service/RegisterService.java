package com.capco.trainingmanagement.microservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capco.trainingmanagement.microservice.model.Employee;
import com.capco.trainingmanagement.microservice.model.ResponseObject;


@Service
public interface RegisterService {

public ResponseEntity<ResponseObject> registerUser(Employee emp);	
}
