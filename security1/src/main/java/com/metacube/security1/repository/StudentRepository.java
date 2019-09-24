package com.metacube.security1.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.security1.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByFirstNameContainingIgnoreCase(String studentFirstName);
	
	
	public List<Student> findByEmailContainingIgnoreCase(String studentEmail);
}