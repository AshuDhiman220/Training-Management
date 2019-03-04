package com.capco.trainingmanagement.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;

@Repository
public interface IUserRegistration extends JpaRepository<EmployeeEntity,Integer>{

	EmployeeEntity findByEmail(String email);


	
}
