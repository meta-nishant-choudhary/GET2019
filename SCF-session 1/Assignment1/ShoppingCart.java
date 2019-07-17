package com.metacube;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Item> cart = new ArrayList<Item>();
		List<Item> items = new ArrayList<Item>();

		Item obj1 = new Item();
		obj1.setId(1);
		obj1.setName("Bag");
		obj1.setCost(240);
		items.add(obj1);

		Item obj2 = new Item();
		obj2.setId(2);
		obj2.setName("Belt");
		obj2.setCost(155);
		items.add(obj2);

		Item obj3 = new Item();
		obj3.setId(3);
		obj3.setName("Shirt");
		obj3.setCost(399);
		items.add(obj3);

		Item.ShowItems(items);
	 
		int choice = 0;
		
		do{
			System.out.println("\nChoice Option");
			System.out.println("1. Add To Cart");
			System.out.println("2. Update Cart");
			System.out.println("3. Show Cart");
			System.out.println("4. Generate Bill");
			System.out.println("0. exit");
			System.out.println("Enter Your Choice:");
			choice = input.nextInt();
			if(choice == 1){
				Item.ShowItems(items);
				System.out.println("Select Item:");
				Integer selectItem = input.nextInt();
				Item.addToCart(selectItem, items, cart);
			}
			else if(choice == 2){
				Integer result = Item.ShowCart(cart);
				int flag = 0;
				if(result == 1){
					do{
						try {
							System.out.println("Select Item by serial no. = ");
							Integer sno = input.nextInt();
							if(sno <= cart.size() && sno > 0){
								System.out.println("Enter New Quantity(0 to remove from cart)");
								Integer newQuantity = input.nextInt();
								Item.update(sno, newQuantity, cart);
							}
							else{
								System.out.println("Dont find Selected Item");
							}
							flag = 1;
						}
						catch ( Exception e ) {
							System.out.println("Wrong input");
							input.nextLine();
						}
					} while ( flag == 0 );
				}	
			}
			else if(choice == 3){
				Integer result = Item.ShowCart(cart);
			}
			else if(choice == 4){
				Item.generateBill(cart);
			}
			else {
				System.out.println("Input out of option. Choose again: ");
			}
		}while(choice != 0);
		System.out.println("exit");
	}
}
