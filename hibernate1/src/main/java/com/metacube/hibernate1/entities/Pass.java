package com.metacube.hibernate1.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "pass")
public class Pass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", updatable = false, nullable = false)
	int eId;
	
	@Column(name = "v_id")
	int vId;
	
	@Column(name = "price")
	String price;
	
	@Column(name = "E_id")
	String plan;
	
	@Column(name = "plan")
	String type;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
}
