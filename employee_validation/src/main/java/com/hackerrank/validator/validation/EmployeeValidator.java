package com.hackerrank.validator.validation;

import com.hackerrank.validator.model.Employee;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object employeeObject, Errors errors) {

     Employee emp = (Employee) employeeObject;
   	 if (emp.getFullName() == null || emp.getFullName().trim().isEmpty()) {
   	            errors.rejectValue("fullName", "fullName.mandatory", "The fullName is a mandatory field");
   	        }
   	 
   	 
   	 	if(emp.getMobileNumber() == null) {
            errors.rejectValue("mobileNumber", "mobileNumber.mandatory", "The mobileNumber is a mandatory field");

   	 	}else {
   	 		
   	 		String mobile = Long.toString(emp.getMobileNumber());
   	 		if (!mobile.matches("\\d{10}")) {
   	 			
   	 			errors.rejectValue("mobileNumber", "mobileNumber.mandatory", "The mobileNumber is a mandatory field");
   	 		}
   	 	}

   	        

       String email = emp.getEmailId();
       if (email == null || email.trim().isEmpty()) {
           errors.rejectValue("emailId", "emailId.mandatory", "The emailId is a mandatory field");
       } else if (!email.contains("@")) {
           errors.rejectValue("emailId", "emailId.invalidFormat", "The emailId should be in a valid email format");
       }


       String dob = emp.getDateOfBirth();
       if (dob == null || dob.trim().isEmpty()) {
           errors.rejectValue("dateOfBirth", "dateOfBirth.mandatory", "The dateOfBirth is a mandatory field");
       } else if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
           errors.rejectValue("dateOfBirth", "dateOfBirth.invalidFormat", "The dateOfBirth should be in YYYY-MM-DD format");
       }

   }

    }

