package com.guvi.Learnjpa.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeTypeValidator implements ConstraintValidator<ValidateEmployeeType, String>{

	@Override
	public boolean isValid(String employeeType, ConstraintValidatorContext arg1) {
		employeeType=employeeType.toLowerCase();
		if(employeeType==null) return false;
		List<String> type=Arrays.asList("fulltime", "intern");
		return type.contains(employeeType);

	}

}
