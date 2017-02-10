package com.dub.site.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;

@Service
public class IntegerFieldValidator implements ConstraintValidator<IntegerField, String> {
	
	@Override
	public void initialize(IntegerField arg0) {
		
	}

	@Override
	public boolean isValid(String intStr, ConstraintValidatorContext context) {		
		if (intStr.matches("^[0-9]+$")) {			
			return true;			
		} else { 				
			return false; 
		}
	}
		
}
