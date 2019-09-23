package com.metacube.shoppingcart.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingcart.entities.Product;
import com.metacube.shoppingcart.entities.ShoppingCart;
import com.metacube.shoppingcart.entities.User;
import com.metacube.shoppingcart.entities.ViewCart;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.ShoppingCartFacade;
import com.metacube.shoppingcart.facade.UserFacade;

public class View {

	public static void main(String[] args) throws Exception {
		
		UserFacade userFacade = UserFacade.getInstance();
		ProductFacade productFacade = ProductFacade.getInstance();
		ShoppingCartFacade cartFacade = ShoppingCartFacade.getInstance();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your Name:");
		String name = input.nextLine();
		User user = userFacade.addUser(name);
		Integer choice=null;
		while(true){
			showChoice();
			choice=input.nextInt();
			if(choice==1){
				List<Product> listProduct= (ArrayList<Product>) productFacade.getallProducts();
				System.out.println("Id"+"\t"+"Product Name"+"\t"+"Type"+"\t"+"Quantity"+"\t\t"+"Price");
				for(Product product : listProduct){
					System.out.println(product);
				}
				System.out.println("Select Item by Id:");
				Integer itemId = input.nextInt();
				System.out.println("Enter Quantity:");
				Integer quantity = input.nextInt();
				if(productFacade.productInStore(itemId, quantity)){
					Product product = productFacade.getProductbyCode(itemId);
					ShoppingCart cart = new ShoppingCart();
					cart.setProductid(product.getProductcode());
					cart.setUserid(user.getUserId());
					cart.setQuantity(quantity);
					cart.setPrice(product.getProductPrice());
					cart.setTotal(quantity*product.getProductPrice());
					if(cartFacade.addItemToCart(cart)){
						System.out.println("Item Added SuccessFully");
					}
					else
						System.out.println("Not Added");
				}
				else{
					System.out.println("Stock not in available");
				}
				
			}
			else if(choice==2){
				System.out.println("Id"+"\t"+"Product Name"+"\t"+"Price"+"\t"+"Quantity"+"\t"+"Total");
				List<ViewCart> cart= cartFacade.getShoppingCart(user.getUserId());
				for(ViewCart view : cart){
					System.out.println(view);
				}
				System.out.println("1. Edit Cart Item");
				System.out.println("Any Other to exit");
				Integer editcart = input.nextInt();
				if(editcart == 1){
					System.out.println("Enter item id");
					Integer itemId = input.nextInt();
					System.out.println("Enter New Quantity(0 to remove)");
					Integer quantity = input.nextInt();
					if(quantity<=0){
						if(cartFacade.removeItemFromcart(itemId))
							System.out.println("Item removed from cart");
					}
					else{
						if(cartFacade.updateCart(itemId, quantity))
							System.out.println("Edit Successfully");
					}
				}
			}
			else
				System.exit(1);
		}
		
	}
	public static void showChoice(){
		System.out.println("1. Add Products");
		System.out.println("2. Show Cart");
		System.out.println("Press any key to exit");
	}

}
