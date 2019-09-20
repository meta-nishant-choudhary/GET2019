package com.metacube.hibernate1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@SuppressWarnings("deprecation")
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="id")
	int id;
	
	@Column(name="Name")
	String name;
	
	@Column(name="gender")
	String gender;
	
	
	@Column(name="Email", unique=true)
	String email;
	
	@Column(name="password")
	String password;
	
	String cPassword;
	
	@Column(name="Contact")
	String contact;
	
	@Column(name="Organization")
	String org;
	
	public Employee() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	
	
}
