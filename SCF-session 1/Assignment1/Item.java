package com.metacube;
import java.util.Scanner;
import java.util.List;

public class Item {
	
	public static Scanner input = new Scanner(System.in);
	int id;
	String itemName;
	double itemCost;
	int quantity;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}

	public void setName(String itemName){
		this.itemName = itemName;
	}

	public String getName(){
		return this.itemName;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return this.quantity;
	}

	public void setCost(double itemCost){
		this.itemCost = itemCost;
	}

	public double getCost(){
		return this.itemCost;
	}

	public static void addToCart(Integer selectItem, List<Item> items, List<Item> cart){
		Scanner input = new Scanner(System.in);
		Integer flag = 0;
		
		for(Item obj : items){
			if (obj.id == selectItem){
				flag = 1;
				System.out.println("Enter Quantity:");
				Integer quantity = input.nextInt();
				
				obj.setName(obj.getName());
				obj.setQuantity(quantity);
				obj.setCost(obj.getCost());

				cart.add( obj );
			}
		}
		if(flag == 1){
			System.out.println("Item Added To Cart");
		}
		else{
			System.out.println("Wrong Choice Try Again....");
		}
	}
	
	public static int ShowCart(List<Item> cart){
		if (cart.isEmpty()) {
			System.out.println("Cart is Empty");
			return 0;
		}
		else {
			int sno = 1;
			System.out.println("Sno.\tItem Name\tItem Price\tItem Quantity\t");
			
			for(Item obj : cart){
			System.out.println( sno + "\t" + obj.getName() + "\t\t" + obj.getCost() + "\t\t" + obj.getQuantity() );
			sno++;
			}
		}
		return 1;
	}
	
	public static void update(Integer sno,Integer newQuantity, List<Item> cart) {
		sno = sno-1;
		Item updateCart = cart.get(sno);
		if (newQuantity <= 0) {
			cart.remove(updateCart);
		}
		else {			
			updateCart.setQuantity(newQuantity);			
		}
	}

	public static void generateBill(List<Item> cart) {
		double total = 0;
		
		for (Item obj : cart) {
			total += obj.getQuantity() * obj.getCost();
		}
		
		ShowCart(cart);
		System.out.println("Bill: \nTotal Amount: " + total);
	}

	public static void ShowItems(List<Item> items) {
		System.out.println("Sno.\tName\tPrice");
		
		for (Item obj : items) {
			System.out.println( obj.getId() + "\t" + obj.getName() + "\t" + obj.getCost() );
		}
	}
}
