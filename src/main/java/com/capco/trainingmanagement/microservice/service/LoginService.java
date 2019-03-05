package com.capco.trainingmanagement.microservice.service;


import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;

public interface LoginService {
	
	public EmployeeEntity findOne(String email);

}
