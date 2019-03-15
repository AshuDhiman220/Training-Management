package com.capco.trainingmanagement.microservice.service.impl;


import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.entity.SecurityQaEntity;
import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;
import com.capco.trainingmanagement.microservice.model.Employee;
import com.capco.trainingmanagement.microservice.model.ResponseObject;
import com.capco.trainingmanagement.microservice.repository.ISecurityQuestions;
import com.capco.trainingmanagement.microservice.repository.IUserRegistration;
import com.capco.trainingmanagement.microservice.service.RegisterService;
import com.capco.trainingmanagement.microservice.validations.RegistrationValidation;
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired 
	IUserRegistration iUserRegistration;
	
	@Autowired
	ISecurityQuestions iSecurityQuestions;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	ISecurityQuestions securityQuestions;
	
	EmployeeEntity employee;
	

	SecurityQaEntity securityQaEntity;
	
	
	
	

	@Override
	public ResponseEntity<ResponseObject> registerUser(Employee emp) throws ValidationFailureException, Exception {
		RegistrationValidation.lengthValidationForFirstName(emp.getFirstName());
		RegistrationValidation.lengthValidationForLastName(emp.getLastName());
		for(Map.Entry<String, String> entry : emp.getSecurityQa().entrySet()) {
		RegistrationValidation.lengthValidationForFirstName(entry.getValue());
		}
		RegistrationValidation.isEmailValid(emp.getEmail());
		RegistrationValidation.isValidPassword(emp.getPassword());
		RegistrationValidation.skillValidation(emp.getSkill());
		RegistrationValidation.dobValidation(emp.getDob());
		EmployeeEntity empEntity=iUserRegistration.findByEmail(emp.getEmail());
		
		if(empEntity != null)
			throw new ValidationFailureException(5003);
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
      employee=new EmployeeEntity();
      employee.setEmail(emp.getEmail());
      employee.setDob(sdf.parse(emp.getDob()));
      employee.setFirstName(emp.getFirstName());
      employee.setLastName(emp.getLastName());
      employee.setPassword(encoder.encode(emp.getPassword()));
      employee.setSkill(emp.getSkill());
      
    
     iUserRegistration.save(employee);
     System.out.println("q and a---"+emp.getSecurityQa());
      setSecurityQAEntity(emp.getSecurityQa(), emp.getEmail());
      
		return new ResponseEntity<>(HttpStatus.OK);
	}



	
	private void setSecurityQAEntity(Map<String, String> sQA, String email) {
		System.out.println("in security QA");
		
		EmployeeEntity empDetail= iUserRegistration.findByEmail(email);
		
		for (Map.Entry<String, String> entry : sQA.entrySet()) {
			securityQaEntity=new SecurityQaEntity();
			securityQaEntity.setEmployeeEntity(empDetail);
		//securityQaEntity.setEmployeeEntity(empDetail);
		securityQaEntity.setQuestion(entry.getKey());
		securityQaEntity.setAnswer(entry.getValue()); 
		
		iSecurityQuestions.save(securityQaEntity);
		System.out.println(iSecurityQuestions.save(securityQaEntity));
		//iSecurityQuestions.saveSecurityQuestions(entry.getValue(), empDetail.getId(), entry.getKey());
		System.out.println(" size of EntrysEt :" +sQA.keySet().size());
		System.out.println(  "Values fpudn in Security question"+ sQA.values());
		System.out.println("question--"+entry.getKey());
		System.out.println("answer---"+entry.getValue());
		}
		System.out.println("security QA--"+securityQaEntity);
		
		
	}
	

}
