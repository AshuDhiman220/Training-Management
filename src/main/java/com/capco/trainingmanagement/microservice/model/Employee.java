package com.capco.trainingmanagement.microservice.model;

import java.util.Date;
import java.util.Map;

public class Employee {

	private String empName;
	private String email;
	private String password;
	private Date dob;
	private String skill;
	private Map<String,String> securityQa;
	private String roleType;
	
	
	/**
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the securityQa
	 */
	public Map<String, String> getSecurityQa() {
		return securityQa;
	}
	/**
	 * @param securityQa the securityQa to set
	 */
	public void setSecurityQa(Map<String, String> securityQa) {
		this.securityQa = securityQa;
	}
	/**
	 * @return the roleType
	 */
	public String getRoleType() {
		return roleType;
	}
	/**
	 * @param roleType the roleType to set
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", email=" + email + ", password=" + password + ", dob=" + dob
				+ ", skill=" + skill + ", securityQa=" + securityQa + ", roleType=" + roleType + "]";
	}
	
	
	
	
}
