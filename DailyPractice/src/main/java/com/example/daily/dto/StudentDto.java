package com.example.daily.dto;

import java.io.Serializable;

public class StudentDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String rollNumber;
	private String university;
	
	public StudentDto() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}

}
