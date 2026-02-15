package com.guvi.Learnjpa.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeTypeValidator.class)
public @interface ValidateEmployeeType {
public String message() default "Invalid employeetype";

Class<?>[] groups() default {};
Class<? extends Payload>[] payload() default {};

}
