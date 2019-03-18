package com.capco.trainingmanagement.microservice.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_DEFAULT)
public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private String skill;
	private Map<String, String> securityQa;
	private String roleType;
	private long contactNumber;
	private Boolean trainerRole;
	private Boolean adminRole;
	private Boolean learnerRole;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
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

	public Boolean getTrainerRole() {
		return trainerRole;
	}

	public void setTrainerRole(Boolean trainerRole) {
		this.trainerRole = trainerRole;
	}

	public Boolean getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(Boolean adminRole) {
		this.adminRole = adminRole;
	}

	public Boolean getLearnerRole() {
		return learnerRole;
	}

	public void setLearnerRole(Boolean learnerRole) {
		this.learnerRole = learnerRole;
	}

	
}
