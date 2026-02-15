package com.guvi.Learnjpa.Dto;

import com.guvi.Learnjpa.validation.ValidateEmployeeType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = (long) 1000.00, message = "Salary must be at least 1000")
    private double salary;

    @NotBlank(message = "Department is required")
    private String department;
    
    @ValidateEmployeeType(message="The employee type either Intern or Fulltime ")
    private String employeeType;
}
