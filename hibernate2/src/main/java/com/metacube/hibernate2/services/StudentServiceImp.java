package com.metacube.hibernate2.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.hibernate2.entity.StudentEntity;
import com.metacube.hibernate2.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	StudentRepository studentRepo;
	
	public void getRepository(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	
	@Override
	public void insertData(StudentEntity sObj) {
		//studentdaoObj.add(sObj);
		studentRepo.save(sObj);
	}

	
	@Override
	public List<StudentEntity> getAll() {
		return studentRepo.findAll();
	}
	
	
	@Override
	public List<StudentEntity> duplicateEmail(StudentEntity sObj) {
		return studentRepo.findByEmailContainingIgnoreCase(sObj.getEmail());
	}
	
	
	@Override
	public List<StudentEntity> findByID(StudentEntity sObj) {
		return studentRepo.findByLastNameAndFirstName(sObj.getLastName() , sObj.getFirstName());
	}
	
	
	

}