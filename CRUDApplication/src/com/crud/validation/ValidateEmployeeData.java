package com.crud.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmployeeData 
{
	public static boolean validateId(int id)
	{
		if(id>0 && id<1000000)
			return true;
		else
			return false;
	}
	
	public static boolean validateName(String name)
	{
		Pattern pattern=Pattern.compile("[^a-z]",Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(name);
		
		if(matcher.find())
			return false;
		else
			return true;
	}
	
	public static boolean validateEmail(String email)
	{
		Pattern pattern=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(email);
		
		if(matcher.find())
			return true;
		else
			return false;
	}
	
	public static boolean validateContact(String contact)
	{
		Pattern pattern=Pattern.compile("\\d{10}",Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(contact);
		
		if(matcher.find())
			return true;
		else
			return false;
	}
	
	public static boolean validatePassword(String password)
	{
		Pattern pattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$",Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(password);
		
		if(matcher.find())
			return true;
		else
			return false;
	}
	
	/*
	 * Pattern Explanation
	 * 
		^                 # start-of-string
		(?=.*[0-9])       # a digit must occur at least once
		(?=.*[a-z])       # a lower case letter must occur at least once
		(?=.*[A-Z])       # an upper case letter must occur at least once
		(?=.*[@#$%^&+=])  # a special character must occur at least once
		(?=\S+$)          # no whitespace allowed in the entire string
		.{6,}             # anything, at least eight places though
		$   
	 */
}
