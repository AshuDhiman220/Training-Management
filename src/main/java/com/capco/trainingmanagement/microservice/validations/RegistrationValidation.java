package com.capco.trainingmanagement.microservice.validations;

import java.util.regex.Pattern;


import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;

public class RegistrationValidation {

	public static void lengthValidationForName(String name) throws ValidationFailureException {
		
		if(name.length()>50 || name.isEmpty() )
			throw new ValidationFailureException(5001);
		
	}
	
	 public static void isEmailValid(String email) throws ValidationFailureException
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	                              
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (!(pat.matcher(email).matches()) || email == null) 
	            throw new ValidationFailureException(5001);
	    } 
	 
	 public static void isValidPassword(String password)throws ValidationFailureException{
		 if(!(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$") || password == null))
				 throw new ValidationFailureException(5001);
		
	 }
	 
	 public static void skillValidation(String skill) throws ValidationFailureException {
		 
		 if(skill == null)
			 throw new ValidationFailureException(5001);
	 }

	public static void roleTypeValidation(String roleType) throws ValidationFailureException {
		if(roleType == null)
			throw new ValidationFailureException(5001);
	}
}
