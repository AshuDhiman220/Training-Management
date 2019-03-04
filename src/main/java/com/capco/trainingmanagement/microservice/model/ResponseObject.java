package com.capco.trainingmanagement.microservice.model;


public class ResponseObject {
	
	private Status status;
	private Employee result;
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the result
	 */
	public Employee getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Employee result) {
		this.result = result;
	}
	

}
