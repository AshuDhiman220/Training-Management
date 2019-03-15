package com.capco.trainingmanagement.microservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.entity.SecurityQaEntity;

@Repository
@Transactional
public interface ISecurityQuestions extends JpaRepository<SecurityQaEntity, Integer> {

	public SecurityQaEntity findByEmployeeEntityId(int id);
	
	public SecurityQaEntity findByQuestionAndEmployeeEntityAndAnswer(String question,EmployeeEntity employeeEntity,String answer);
}
