package com.example.daily.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.daily.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	@Modifying		
	@Query("delete from Student s  where s.id=:id")
	public void deleteIdUsingQueryAnnotation(@Param("id") Long id);
	
	public Student findByName(String name);
}
