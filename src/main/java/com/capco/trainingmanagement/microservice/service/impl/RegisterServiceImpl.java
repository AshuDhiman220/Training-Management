package com.capco.trainingmanagement.microservice.service.impl;


import java.text.SimpleDateFormat;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.entity.RoleEntity;
import com.capco.trainingmanagement.microservice.entity.SecurityQaEntity;
import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;
import com.capco.trainingmanagement.microservice.model.Employee;
import com.capco.trainingmanagement.microservice.model.ResponseObject;
import com.capco.trainingmanagement.microservice.repository.IRoleRepository;
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
	IRoleRepository iRoleRepository;
	@Autowired
	ISecurityQuestions securityQuestions;
	
	EmployeeEntity employee;
	

	SecurityQaEntity securityQaEntity;
	
	RoleEntity roleEntity;
	
	
	

	@Override
	public ResponseEntity<ResponseObject> registerUser(Employee emp) throws ValidationFailureException, Exception {
		RegistrationValidation.lengthValidationForName(emp.getFirstName());
		RegistrationValidation.lengthValidationForName(emp.getLastName());
		for(Map.Entry<String, String> entry : emp.getSecurityQa().entrySet()) {
		RegistrationValidation.lengthValidationForName(entry.getValue());
		}
		RegistrationValidation.isEmailValid(emp.getEmail());
		RegistrationValidation.isValidPassword(emp.getPassword());
		RegistrationValidation.skillValidation(emp.getSkill());
		RegistrationValidation.roleTypeValidation(emp.getRoleType());
		EmployeeEntity empEntity=iUserRegistration.findByEmail(emp.getEmail());
		if(empEntity != null)
			throw new ValidationFailureException(5003);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dob=sdf.format(emp.getDob());
      employee=new EmployeeEntity();
      roleEntity=new RoleEntity();
      employee.setEmail(emp.getEmail());
      employee.setDob(sdf.parse(dob));
      employee.setFirstName(emp.getFirstName());
      employee.setLastName(emp.getLastName());
      employee.setPassword(encoder.encode(emp.getPassword()));
      employee.setSkill(emp.getSkill());
      
     RoleEntity  role=iRoleRepository.findByRoleType(emp.getRoleType());
     if(role == null)
    	 throw new ValidationFailureException(5001);
     System.out.println("role entity is---"+role);
     employee.setRoleEntity(role);
     iUserRegistration.save(employee);
     System.out.println("q and a---"+emp.getSecurityQa());
      setSecurityQAEntity(emp.getSecurityQa(), emp.getEmail());
      
		return new ResponseEntity<>(HttpStatus.OK);
	}




	private void setSecurityQAEntity(Map<String, String> sQA, String email) {
		System.out.println("in security QA");
		securityQaEntity=new SecurityQaEntity();
		EmployeeEntity empDetail= iUserRegistration.findByEmail(email);
		securityQaEntity.setEmployeeEntity(empDetail);
		for (Map.Entry<String, String> entry : sQA.entrySet()) {
		securityQaEntity.setQuestion(entry.getKey());
		securityQaEntity.setAnswer(entry.getValue()); 
		System.out.println("question--"+entry.getKey());
		System.out.println("answer---"+entry.getValue());
		}
		System.out.println("security QA--"+securityQaEntity);
		iSecurityQuestions.save(securityQaEntity);
		
	}
	

}
