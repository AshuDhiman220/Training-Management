package com.capco.trainingmanagement.microservice.model;

import java.util.Date;
import java.util.Map;

public class Employee {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dob;
	private String skill;
	private Map<String, String> securityQa;
	private String roleType;
	private long contactNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Map<String, String> getSecurityQa() {
		return securityQa;
	}

	public void setSecurityQa(Map<String, String> securityQa) {
		this.securityQa = securityQa;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

}
