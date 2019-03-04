package com.capco.trainingmanagement.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity(name="security_qa")
public class SecurityQaEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int questionId;
	@Column(name="question")
	private String question;
	@Column(name="answer")
	private String answer;
	@OneToOne
    @JoinColumn(name="id")
	private EmployeeEntity employeeEntity;
	/**
	 * @return the questionId
	 */
	public int getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * @return the employeeEntity
	 */
	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}
	/**
	 * @param employeeEntity the employeeEntity to set
	 */
	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityQaEntity [questionId=" + questionId + ", question=" + question + ", answer=" + answer
				+ ", employeeEntity=" + employeeEntity + "]";
	}
	
	
}
