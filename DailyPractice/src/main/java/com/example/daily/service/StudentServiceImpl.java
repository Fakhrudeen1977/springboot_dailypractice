package com.example.daily.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.daily.dto.StudentDto;
import com.example.daily.entity.Student;
import com.example.daily.mapper.OrikaBeanMapper;
import com.example.daily.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private OrikaBeanMapper mapper;
	

	@Override
	@Transactional
	
	@CachePut(value = "student", key = "#student.id")
	public StudentDto saveStudent(StudentDto studentDto) {
		 Student student= mapper.map(studentDto,Student.class);
		 student=studentRepository.saveAndFlush(student);
		 
		StudentDto studentDtoResp= mapper.map(student, StudentDto.class);
		return studentDtoResp;
		
	}	
	

	@Override
	public List<StudentDto> getStudentList() {
		// TODO Auto-generated method stub
		
		List<Student> studentList=studentRepository.findAll();
		
		List<StudentDto> studentDtoList=mapper.mapAsList(studentList, StudentDto.class);
		return studentDtoList;
			
		
	}


	@Override
	@Transactional
	public String deleteIdUsingQueryAnnotation(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteIdUsingQueryAnnotation(id);
		
		return "Record deleted successfully using @Modifiying and @query Named Parameter";
	}


	@Override
	@Cacheable(value = "student", key = "#id")
	public StudentDto getStudent(Long id) {
		System.out.println("Hitting from DB");
		Optional<Student> studentOption=studentRepository.findById(id);
		StudentDto studentDtoResp=null;
		Student student=new Student();
		if (studentOption.isPresent()) {
			student=studentOption.get();
			studentDtoResp= mapper.map(student, StudentDto.class);
			
		}
		return studentDtoResp;

		 
	}


	@Override
	public StudentDto findByName(String namew) {
		Student student=studentRepository.findByName(namew);
		StudentDto studentDtoResp= mapper.map(student, StudentDto.class);
		return studentDtoResp;
		
	}


	@Override
	public List<StudentDto> findByRollNumberIn(List<String> rollNumbers) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
