package com.metacube.hibernate2.services;
import java.util.List;

import org.springframework.stereotype.Service;
import com.metacube.hibernate2.entity.StudentEntity;

@Service
public interface StudentService {

	void insertData(StudentEntity sObj);

	public List<StudentEntity> getAll();

	List<StudentEntity> duplicateEmail(StudentEntity sObj);

	List<StudentEntity> findByID(StudentEntity map);


}