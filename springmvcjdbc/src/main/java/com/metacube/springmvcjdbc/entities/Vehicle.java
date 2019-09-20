package com.metacube.springmvcjdbc.entities;

import javax.validation.constraints.Pattern;

public class Vehicle {
	
	int id;
	String name;
	String type;
	String number;
	int eid;
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
