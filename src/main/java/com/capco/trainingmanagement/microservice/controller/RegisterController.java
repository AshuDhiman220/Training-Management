package com.capco.trainingmanagement.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;
import com.capco.trainingmanagement.microservice.model.ApiResponse;
import com.capco.trainingmanagement.microservice.model.Employee;
import com.capco.trainingmanagement.microservice.model.ResponseObject;
import com.capco.trainingmanagement.microservice.model.SecurityQa;
import com.capco.trainingmanagement.microservice.service.LoginService;
import com.capco.trainingmanagement.microservice.service.RegisterService;
import com.capco.trainingmanagement.microservice.util.CommonUtility;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@Autowired
	private LoginService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<ResponseObject> registerUser(@RequestBody Employee emp) throws Exception {
		ResponseEntity<ResponseObject> response = registerService.registerUser(emp);
		return CommonUtility.responseMessage(200, "success", HttpStatus.OK);
	}

	@GetMapping("/{email}")
	public ApiResponse<EmployeeEntity> getOne(@PathVariable String email) {
		return new ApiResponse<>(HttpStatus.OK.value(), "success", userService.findOne(email));
	}
	
	@PostMapping("/verify/securityqa")
	public ResponseEntity<ResponseObject> verifySecurityQA(@RequestBody SecurityQa securityQa) throws Exception{
		return userService.verfiySecurityQA(securityQa);
	}
}
