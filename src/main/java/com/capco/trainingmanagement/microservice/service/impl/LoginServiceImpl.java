package com.capco.trainingmanagement.microservice.service.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.entity.SecurityQaEntity;
import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;
import com.capco.trainingmanagement.microservice.model.ResponseObject;
import com.capco.trainingmanagement.microservice.model.SecurityQa;
import com.capco.trainingmanagement.microservice.model.Status;
import com.capco.trainingmanagement.microservice.repository.ISecurityQuestions;
import com.capco.trainingmanagement.microservice.repository.IUserRegistration;
import com.capco.trainingmanagement.microservice.service.LoginService;
@Service(value="loginService")
public class LoginServiceImpl implements UserDetailsService,LoginService {
	
	@Autowired
	private IUserRegistration iUserRegistration;
	@Autowired
	private ISecurityQuestions securityQuestions;
	
	@Override
	public EmployeeEntity findOne(String email) {
		
		return iUserRegistration.findByEmail(email);
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		EmployeeEntity user = iUserRegistration.findByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	@Override
	public ResponseEntity<ResponseObject> verfiySecurityQA(SecurityQa sqa) throws ValidationFailureException, Exception{
		SecurityQaEntity sqaEntity=new SecurityQaEntity();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dob=sdf.format(sqa.getDob());
		ResponseObject resObject=new ResponseObject();
		Status status=new Status();
		
		EmployeeEntity employeeEntity=iUserRegistration.findByDob(sdf.parse(dob));
		System.out.println("dob is---"+employeeEntity+"input dob is---"+sqa.getDob());
		if(employeeEntity == null)
			throw new ValidationFailureException(5001);
		System.out.println(sqa.toString());
		System.out.println(sqa.getQa());
		for(Map.Entry<String, String> entry: sqa.getQa().entrySet()) {
			System.out.println("quesion is---"+entry.getKey());
			sqaEntity=securityQuestions.findByEmployeeEntityId(employeeEntity.getId());
			if(entry.getValue().matches(sqaEntity.getAnswer()) ) {
				status.setCode(200);
				status.setMessage("Success");
				resObject.setStatus(status);
			}
		}
		return new ResponseEntity<>(resObject, HttpStatus.OK);
	}
	
}
