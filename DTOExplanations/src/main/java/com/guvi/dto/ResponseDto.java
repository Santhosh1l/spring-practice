package com.guvi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	private int id;
	private int deptId;
	private String fullName;
	private String dept;
}
