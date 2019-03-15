package com.capco.trainingmanagement.microservice.validations;

import java.util.Date;
import java.util.Map;


import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;
import com.capco.trainingmanagement.microservice.model.SecurityQa;

public class SecurityQuestionValidation {

	public static void validatesecurityQA(SecurityQa sQa) throws ValidationFailureException {
		
		
		RegistrationValidation.isEmailValid(sQa.getEmail());
		RegistrationValidation.isValidPassword(sQa.getPassword());
	}
	
	public static boolean securityQaDobVerfication(Date securityQa, Date dob) throws ValidationFailureException {
		
		if(securityQa.compareTo(dob)==0) 
			 return true;
		else
		throw new ValidationFailureException(5010);
		
	}
}
