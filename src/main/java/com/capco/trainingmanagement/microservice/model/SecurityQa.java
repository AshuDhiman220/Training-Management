package com.capco.trainingmanagement.microservice.model;

import java.util.Date;
import java.util.Map;

public class SecurityQa {
	
	private Map<String,String> qa;
	private Date dob;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "SecurityQa [qa=" + qa + ", dob=" + dob + "]";
	}
		
	

}
