package com.internaltools.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringPhoneNumberValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
    	
    	String allCountryRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
    	if(phoneNumber == null) {
        	return false;
        } 
    	if(phoneNumber.matches(allCountryRegex)) {
        	return true;
        } else return false;
    }

}