package com.metacube.security1.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student_detail")
public class Student {

	@Id
	@Column(name="roll_no")
	int id;
	@Column(name="first_name")
	String firstName;
	@Column(name="last_name")
	String lastName;
	@Column(name="father_name")
	String fatherName;
	@Column(name="E_mail")
	String email;
	@Column(name="class")
	String studentClass;
	@Column(name="Age")
	String studentAge;
	
	public Student() {
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