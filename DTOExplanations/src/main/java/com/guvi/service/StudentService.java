package com.guvi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guvi.dto.CreateDto;
import com.guvi.dto.ResponseDto;
import com.guvi.mapper.StudentMapper;
import com.guvi.model.Student;
import com.guvi.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public ResponseDto create(CreateDto data) {
		Student entity = StudentMapper.toEntity(data);
		return StudentMapper.toResponse(repo.save(entity));
	}

	public List<ResponseDto> findAll() {
		return StudentMapper.toResponseList(repo.findAll());
	}

	public ResponseDto findById(int id) {
		Student byId = repo.findById(id).orElse(null);
		return StudentMapper.toResponse(byId);
	}

}
