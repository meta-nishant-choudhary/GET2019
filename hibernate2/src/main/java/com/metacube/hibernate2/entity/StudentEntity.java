package com.metacube.hibernate2.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentEntity {

	@Id
	int id;
	@Column(name="first_Name")
	String firstName;
	@Column(name="last_Name")
	String lastName;
	@Column(name="father_Name")
	String fatherName;
	@Column(name="E_mail")
	String email;
	@Column(name="class")
	String studentClass;
	@Column(name="Age")
	String studentAge;
	
	public StudentEntity() {
	}
	
	//Getter Setter methods
	public String getStudentAge() {
		return studentAge;
	}
	
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}