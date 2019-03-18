package com.capco.trainingmanagement.microservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity(name="employee")
@JsonInclude(Include.NON_NULL)
public class EmployeeEntity {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="firstName")
	 private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="dob")
	private Date dob;
	@Column(name="password")
	@JsonIgnore
	private String password;
	@Column(name="skill")
	private String skill;
	@Column(name="bio")
	private String bio;
	@Column(name="TRAINER_ROLE")
	private Boolean trainerRole;
	@Column(name="ADMIN_ROLE")
	private Boolean adminRole;
	@Column(name="LEARNER_ROLE")
	private Boolean learnerRole;
   
    @OneToMany(targetEntity=SecurityQaEntity.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = false,
            mappedBy = "employeeEntity",
            fetch = FetchType.EAGER
    )
    @JsonIgnore
	private List<SecurityQaEntity> sQA; 
    
    
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
	
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public List<SecurityQaEntity> getsQA() {
		return sQA;
	}
	public void setsQA(List<SecurityQaEntity> sQA) {
		this.sQA = sQA;
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
