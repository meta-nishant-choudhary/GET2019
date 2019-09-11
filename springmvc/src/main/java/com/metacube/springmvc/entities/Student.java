package com.metacube.springmvc.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Student {
	@NotBlank(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{field.firstname}")
	String firstName;
	
	@NotEmpty(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{field.lastname}")
	String lastName;
	
	@NotEmpty(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{field.fathername}")
	String fatherName;
	
	@NotEmpty(message="{field.empty}")
	@Email(message="{field.email}")
	String email;
	
	@NotNull(message="{field.empty}")
	@Max(value=12, message="{field.classmax}")
	@Min(value=1, message="{field.classmin}")
	int studentClass;
	
	@Max(value=12, message="{field.agemax}")
	@Min(value=1, message="{field.agemin}")
	@NotNull(message="{field.empty}")
	int age;
	
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
	
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
