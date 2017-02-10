package com.dub.site.validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;

@Service
public class DateFieldValidator implements ConstraintValidator<DateField, String> {
	
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	 
	//private Date limDate; 

	
	@Override
	public void initialize(DateField arg0) {
		
	}

	@Override
	public boolean isValid(String dateStr, ConstraintValidatorContext context) {
		
		
		if (dateStr.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
			try {
				formatter.parse(dateStr);
				return true;
			} catch (ParseException e) {
				return false;
			}
		} else { 				
			return false; 
		}
	}
		
}
