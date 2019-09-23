package com.metacube.shoppingcart.entities;

public class ViewCart {
	
	Integer cartId;
	String productName;
	Double price;
	Integer quantity;
	Double total;
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return  cartId + "\t" + productName
				+ "\t" + price + "\t" + quantity + "\t\t"
				+ total;
	}
	
	
	
}
