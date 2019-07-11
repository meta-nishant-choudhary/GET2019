package metacube.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

	public static List<Cart> cart=new ArrayList<Cart>();
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		// TODO Auto-generated method stub
		List<Item> items=new ArrayList<Item>();
		items.add(new Item(1,"Bag",240));
		items.add(new Item(2,"Belt",155));
		items.add(new Item(3,"Shirt",399));
		Integer choice = null;
		
		do{
			
			System.out.println("Choice Option");
			System.out.println("1. Add To Cart");
			System.out.println("2. Update Cart");
			System.out.println("3. Show Cart");
			System.out.println("4. Generate Bill");
			System.out.println("0. To Exit");
			System.out.println("Ënter Your Choice:");
			choice=input.nextInt();
			if(choice==1){
			
				ShowItems(items);
				System.out.println("Select Item:");
				Integer selectItem=input.nextInt();
				addToCart(selectItem,items);
			}
			else if(choice==2){
				Integer result=ShowCart();
				if(result==1){
					System.out.println("Select Item by serial no.=");
					Integer sno=input.nextInt();
					if(sno<=cart.size() && sno>0){
						System.out.println("Enter New Quantity(0 to remove from cart)");
						Integer newQuantity=input.nextInt();
						update(sno,newQuantity);
					}
					else{
						System.out.println("Dont find Selected Item");
					}
				}
				
			}
			else if(choice==3){
				Integer result=ShowCart();
			}
			else if(choice==4){
				GenerateBill();
			}
			else if(choice==0){
				System.out.println("exit");
				break;
			}
			else
				System.out.println("Invalid choice...");
				
		}while(choice!=0);
		System.exit(1);
	}
	
	public static void addToCart(Integer selectItem,List<Item> items){
		Integer flag=0;
		for(Item obj:items){
			if(obj.id==selectItem){
				flag=1;
				System.out.println("Enter Quantity:");
				Integer quantity=input.nextInt();
				Double totalAmount=new Double(quantity*obj.price);
				cart.add(new Cart(obj.name,quantity,obj.price,totalAmount));
						
			}
		}
		if(flag==1){
			System.out.println("Item Added To Cart");
		}else{
			System.out.println("Wrong Choice Try Again....");
		}
		
	}
	
	public static int ShowCart(){
		
		if(cart.isEmpty()){
			System.out.println("Cart is Empty");
			return 0;
		}
			
		else{
			int sno=1;
			System.out.println("Sno.\tItem Name\tItem Price\tItem Quantity\tTotal");
			for(Cart obj:cart){
			System.out.println(sno+"\t"+obj.name+"\t\t"+obj.price+"\t\t"+obj.quantity+"\t\t"+obj.totalAmount);
			sno++;
			}
		}
		return 1;
	}
	
	
	
	public static void update(Integer sno,Integer newQuantity){
		sno=sno-1;
		if(newQuantity<=0){
			Cart updateCart=cart.get(sno);
			cart.remove(updateCart);
			
		}
		else{			
			Cart updateCart=cart.get(sno);
			updateCart.quantity=newQuantity;
			Double total=new Double(updateCart.price*newQuantity);
			updateCart.price=total;
					
		}
		
	}
	
	
	public static void GenerateBill(){
		if(cart.isEmpty()){
			System.out.println("Your Cart is Empty");
		}
		else{
			Double total=new Double(0);
			System.out.println("Sno.\tName\tPrice\tQuantity\tTotal");
			Integer sno=1;
			for(Cart obj:cart){
				total=total+obj.price;
				System.out.println(sno+"\t"+obj.name+"\t"+obj.price+"\t"+obj.quantity+"\t\t"+obj.totalAmount);
			}
			System.out.println("\t\t\t--------------------------");
			System.out.println("\t\t\tTotal Bill\t"+total);
		}
	}
	
	public static void ShowItems(List<Item> items){
			System.out.println("Sno.\tName\tPrice");
			
			for(Item obj:items){
				System.out.println(obj.id+"\t"+ obj.name + "\t" +obj.price);
				
			}
		
	}
	
	
	
	

}
