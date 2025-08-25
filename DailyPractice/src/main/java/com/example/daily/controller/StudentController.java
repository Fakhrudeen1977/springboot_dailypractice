package com.example.daily.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.dto.IdContainerDto;
import com.example.daily.dto.StudentDto;
import com.example.daily.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	 
	@Autowired
	private StudentService studentService;
	
	
	
	@PostMapping("/saveStudent")
	public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
		StudentDto savedStudentto = new StudentDto();

		try {

			if (studentDto.getId() == null) {
				savedStudentto = studentService.saveStudent(studentDto);
			} else {

				savedStudentto = studentService.saveStudent(studentDto);

			}
			return new ResponseEntity<StudentDto>(savedStudentto, HttpStatus.CREATED);

		}

		catch (Exception e) {
			return new ResponseEntity<StudentDto>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	
	@GetMapping("/getStudentList")
	public ResponseEntity<List<StudentDto>> getStudentList() {
	
		List<StudentDto> bloodGroupDtoList = studentService.getStudentList();
		return ResponseEntity.ok(bloodGroupDtoList);
	}
	
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
	
		StudentDto studentDto = studentService.getStudent(id);
		return ResponseEntity.ok(studentDto);
	}
	
	
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		
			ResponseEntity<String> resp = null;
			String message="";
			 try {
				 message=studentService.deleteIdUsingQueryAnnotation(id);
				 resp = new ResponseEntity<String>(message, HttpStatus.OK);
			 }
			 catch(Exception e) {
				 
			 }
						
			 return resp;

	}
	
	
	@GetMapping("/findByName/{name}")
	public ResponseEntity<StudentDto> findByName(@PathVariable String name) {
	
		StudentDto studentDto = studentService.findByName(name);
		return ResponseEntity.ok(studentDto);
	}
	
	
	
	public ResponseEntity<List<StudentDto>> findByRollNumberIn(@RequestBody List<IdContainerDto> idContainers) {
		List<String> rollNumbers = new ArrayList<String>();
		for (IdContainerDto id : idContainers) {
			rollNumbers.add(id.getRollNumber());
		}
		List<StudentDto> studentResponse = (List<StudentDto>) studentService.findByRollNumberIn(rollNumbers);
		return ResponseEntity.ok(studentResponse);
		//return studentResponse;
	}
	
	
	
	
	
	
}


