package com.metacube;

import java.util.Scanner;

public class Area {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer choice = null;
		do{
			System.out.println("Find Area :");
			System.out.println("1. Triangle\n2. Circle\n3. Rectangle\n4. Square");
			choice=input.nextInt();
			Area area = new Area();
			if(choice == 1){
				System.out.println("Enter Base : ");
				Integer base = input.nextInt();
				System.out.println("Enter Height : ");
				Integer height = input.nextInt();
				System.out.println("Area of Triangle : "+String.format("%.2f", area.Triangle(base, height)));
			}
			else if(choice == 2){
				System.out.println("Enter Radius : ");
				Integer radius = input.nextInt();
				System.out.println("Area of Circle : "+String.format("%.2f", area.Circle(radius)));
			}
			else if(choice == 3){
				System.out.println("Enter Length : ");
				Integer length = input.nextInt();
				System.out.println("Enter Breadth : ");
				Integer breadth = input.nextInt();
				System.out.println("Area of Rectangle : "+String.format("%.2f", area.Rectangle(length, breadth)));
			}
			else if(choice == 4){
				System.out.println("Enter Side : ");
				Integer side = input.nextInt();
				System.out.println("Area of Square : "+String.format("%.2f", area.Square(side)));
			}
			else if(choice == 0){
				break;
			}
			else{
				System.out.println("Wrong choice");
			}
		}while(choice != 0);
	}
	/**
	 * area of triangle
	 * @param base
	 * @param height
	 * @return (base*height)/2
	 */
	public double Triangle(double base, double height) {
		return (base*height)/2;
	}
	
	/**
	 * AREA OF CIRCLE
	 * @param radius
	 * @return area = 3.14*radius*radius
	 */
	public double Circle(double radius) {
		return 3.14*(radius*radius);
	}
	
	/**
	 * area of rectangle
	 * @param length
	 * @param breadth
	 * @return area = length * breadth
	 */
	public double Rectangle(double length, double breadth) {
		return length*breadth;
	}
	
	/**
	 * area of square
	 * @param side
	 * @return area = side * side
	 */
	public double Square(double side) {
		return side*side;
	}
}

