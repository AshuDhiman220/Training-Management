package com.capco.trainingmanagement.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.trainingmanagement.microservice.model.Employee;
import com.capco.trainingmanagement.microservice.model.ResponseObject;
import com.capco.trainingmanagement.microservice.service.RegisterService;
import com.capco.trainingmanagement.microservice.util.CommonUtility;

@RestController
@RequestMapping(value="/training")
public class RegisterController {
	
	
	@Autowired
	RegisterService registerService;
	
	
@RequestMapping(value="/register",method=RequestMethod.POST)
	
	public ResponseEntity<ResponseObject> registerUser(@RequestBody Employee emp)
	{
		ResponseEntity<ResponseObject> response=registerService.registerUser(emp);
		return CommonUtility.responseMessage(200, "success", HttpStatus.OK);
		
	}

}
