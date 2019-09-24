package com.metacube.security1.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class StudentForm {
	
	
	@NotBlank
	@Size(min = 2, max =  7, message="First {properName}")
	private String firstName;
	
	
	@NotBlank
	@Size(min = 2, max =  7, message="Last {properName}")
	private String lastName;
	
	
	@NotBlank
	@Size(min = 2, max =  15, message="Father's {properName}")
	private String fatherName;
	
	
	@Email
	@Size(min = 2, max =  30, message="{blankEmail}")
	private String email;
	
	
	@NotBlank
	@Pattern(regexp = "^[1-9]|1[0-2]$",message= "{studentClass}")
	private String studentClass;
	
	
	@NotBlank
	@Pattern(regexp = "^[4-9]|[1-9][0-9]$",message= "{studentAge}")
	private String studentAge;

	public StudentForm()
	{
		
	}
	//Getter Setter methods
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

	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
}