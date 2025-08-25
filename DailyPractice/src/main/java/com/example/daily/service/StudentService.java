package com.example.daily.service;

import java.util.List;

import com.example.daily.dto.StudentDto;


public interface StudentService {
	
	public StudentDto saveStudent(StudentDto studentDto);	
	public List<StudentDto> getStudentList();
	public StudentDto getStudent(Long id);
	public String deleteIdUsingQueryAnnotation(Long id);
	
	public StudentDto findByName(String name);
	
	
	public List<StudentDto> findByRollNumberIn(List<String> rollNumbers);

}
