package com.capco.trainingmanagement.microservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity(name="employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(name="emp_name")
	 private String employeeName;
	@Column(name="email")
	private String email;
	@Column(name="dob")
	private Date dob;
	@Column(name="password")
	private String password;
	@Column(name="skill")
	private String skill;
    @OneToOne
    @JoinColumn(name="role_id")
	private RoleEntity roleEntity;
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	 * @return the roleEntity
	 */
	public RoleEntity getRoleEntity() {
		return roleEntity;
	}
	/**
	 * @param roleEntity the roleEntity to set
	 */
	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}
	

}
