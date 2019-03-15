package com.capco.trainingmanagement.microservice.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class SecurityQa {
	
	private Map<String,String> qa;
	private String dob;
	private String email;
	private String password;

	/**
	 * @return the qa
	 */
	public Map<String, String> getQa() {
		return qa;
	}

	/**
	 * @param qa the qa to set
	 */
	public void setQa(Map<String, String> qa) {
		this.qa = qa;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SecurityQa [qa=" + qa + ", dob=" + dob + "]";
	}
		
	

}
