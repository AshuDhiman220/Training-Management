package com.capco.trainingmanagement.microservice.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.DateValidator;

import com.capco.trainingmanagement.microservice.exceptions.ValidationFailureException;

public class RegistrationValidation {

	public static void lengthValidationForFirstName(String name) throws ValidationFailureException {
		
		if(name.length()>50 || name.isEmpty() )
			throw new ValidationFailureException(5001);
		
		
	}
	
public static void lengthValidationForLastName(String name) throws ValidationFailureException {
		
		if(name.length()>50 || name.isEmpty() )
			throw new ValidationFailureException(5002);
		
		
	}
	
	
	
	 public static void isEmailValid(String email) throws ValidationFailureException
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	                              
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (email == null || !(pat.matcher(email).matches()) ) 
	            throw new ValidationFailureException(5006);
	        if(!email.contains("capco.com"))
	        	throw new ValidationFailureException(5005);
	    } 
	 
	 public static void isValidPassword(String password)throws ValidationFailureException{
		 if(!(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$") || password == null))
				 throw new ValidationFailureException(5007);
		
	 }
	 
	 public static void skillValidation(String skill) throws ValidationFailureException {
		 
		 if(skill == null || skill.isEmpty())
			 throw new ValidationFailureException(5008);
	 }

	public static void roleTypeValidation(String roleType) throws ValidationFailureException {
		if(roleType == null)
			throw new ValidationFailureException(5009);
	}
	
	public static void dobValidation(String dob) throws ValidationFailureException, Exception {
	
		if(dateValidator(dob, "MM/dd/yyyy")== false)
			throw new ValidationFailureException(5004);
			
	}
		
	
	public static boolean dateValidator(String date, String format)
	{
		// Get the Date validator
		DateValidator validator = DateValidator.getInstance();

		// Validate the date
		return validator.isValid(date, Locale.ENGLISH);
	}

	public static void lengthValidationForFirstCompany(String firstCompany) throws ValidationFailureException {
				if(firstCompany==null || firstCompany.isEmpty())
					throw new ValidationFailureException(5011);
	}

}
