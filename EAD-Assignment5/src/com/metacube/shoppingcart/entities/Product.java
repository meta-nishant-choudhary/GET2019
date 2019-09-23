package com.metacube.shoppingcart.entities;

import java.util.List;

public class Product {
	
	Integer productcode;
	String productName;
	String productType;
	Integer quantity;
	Double productPrice;
	
	public Integer getProductcode() {
		return productcode;
	}
	public void setProductcode(Integer productcode) {
		this.productcode = productcode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return productcode + "\t"
				+ productName + "\t" + productType + "\t"
				+ quantity + "\t" + productPrice;
	}
	
	
		
	
}
