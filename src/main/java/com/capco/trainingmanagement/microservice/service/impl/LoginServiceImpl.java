package com.capco.trainingmanagement.microservice.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.repository.IUserRegistration;
import com.capco.trainingmanagement.microservice.service.LoginService;
@Service(value="loginService")
public class LoginServiceImpl implements UserDetailsService,LoginService {
	
	@Autowired
	private IUserRegistration iUserRegistration;
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
}
