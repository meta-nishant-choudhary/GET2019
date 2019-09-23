package com.metacube.hibernate2.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.hibernate2.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

	public List<StudentEntity> 	findByLastNameAndFirstName(String studentFirstName , String studentLastName);

	public List<StudentEntity> findByEmailContainingIgnoreCase(String studentEmail);  
}