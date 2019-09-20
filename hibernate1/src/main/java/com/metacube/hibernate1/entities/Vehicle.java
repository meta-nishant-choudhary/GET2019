package com.metacube.hibernate1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="vehicle", uniqueConstraints=@UniqueConstraint(columnNames="number"))
public class Vehicle {
	
	@Id
	@Column(name="id", updatable = false, nullable = false)
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="type")
	String type;
	
	@Column(name="number")
	String number;
	
	@Column(name="E_id")
	int eid;
	
	@Column(name="Identification")
	String identification;
	
	public Vehicle() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getNumber() {
		return number;
	}
	public void setvNumber(String number) {
		this.number = number;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
