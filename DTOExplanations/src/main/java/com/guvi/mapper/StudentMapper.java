package com.guvi.mapper;

import java.util.List;

import com.guvi.dto.CreateDto;
import com.guvi.dto.ResponseDto;
import com.guvi.model.Student;

public class StudentMapper {

	public static Student toEntity(CreateDto dto) {
		Student s = new Student();
		s.setFullName(dto.getFullName());
		s.setDept(dto.getDept());
		return s;
	}

	public static ResponseDto toResponse(Student s) {
		ResponseDto resp = new ResponseDto();
		resp.setFullName(s.getFullName());
		resp.setDept(s.getDept());
		resp.setDeptId(s.getDeptId());
		resp.setId(s.getId());
		return resp;
	}

	public static List<ResponseDto> toResponseList(List<Student> students) {
		return students.stream().map(StudentMapper::toResponse).toList();
	}

}
