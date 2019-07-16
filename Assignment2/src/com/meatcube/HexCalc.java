package com.meatcube;

import java.util.Scanner;
import java.lang.Math;

public class HexCalc {
	
	public static final String hexadecimalNumber = "0123456789ABCDEF";
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String num1;
		int flag = 0;
		do{
			System.out.println("Enter first number: ");
			num1 = (input.nextLine()).toUpperCase();
			for (int loop = 0; loop < num1.length(); loop++){
				try{
					char c = num1.charAt(loop);
					System.out.println("c "+c);
					int t = hexadecimalNumber.indexOf(c);
					System.out.println("t:"+t);
					flag = 1;
				}
				catch (Exception e){
					System.out.println("Wrong input.");
					flag = 0;
					break;
				}
			}
		} while(flag != 1);
		
		System.out.println("Enter second number: ");
		String num2 = (input.nextLine()).toUpperCase();
		
		int choice = 0;
		do
		{
			System.out.println("\nEnter the arithmatic operation you want to perform: \n"
				+ "1. Addition\n"
				+ "2. Subtract\n"
				+ "3. Dividation\n"
				+ "4. Multiplication\n"
				+ "5. Equallity check\n"
				+ "6. Greater\n"
				+ "7. Smaller\n"
				+ "0. exit\n"
				+ "Option: ");
			
			choice = input.nextInt();
			if(choice == 1){
				System.out.println("Addition : " + add(num1, num2));
			}
			else if(choice == 2){
				System.out.println("Subtraction : " + subtract(num1, num2));
			}
			else if(choice == 3){
				System.out.println("Divide : " + divide(num1, num2));
			}
			else if(choice == 4){
				System.out.println("Multiplication : " + multiplication(num1, num2));
			}
			else if(choice == 5){
				if(equalsTo(num1,num2)){
					System.out.println("num1 and num2 are equal");
				}
				else{
					System.out.println("num1 and num2 are not equal");
				}
			}
			else if(choice == 6){
				if(greater(num1,num2)){
					System.out.println("num1 is greater");
				}
				else{
					System.out.println("num2 is greater");
				}
			}
			else if(choice == 7){
				if(greater(num1,num2)){
					System.out.println("num2 is less");
				}
				else{
					System.out.println("num1 is less");
				}	
			}
			else if (choice == 0){
				break;
			}
		} while(choice != 0);
		System.out.println("exit");
	}	

public static String add(String num1, String num2){
	long res1 = hexaToDecimal(num1); 
	long res2 = hexaToDecimal(num2);
	long result = res1 + res2;
	return decimalToHexa(result);
}

public static String subtract(String num1, String num2){
	long res1 = hexaToDecimal(num1); 
	long res2 = hexaToDecimal(num2);
	long result = res1 - res2;
	return decimalToHexa(result);
}

public static String divide(String num1, String num2){
	long result;
	long res1 = hexaToDecimal(num1); 
	long res2 = hexaToDecimal(num2);
	try {
		result = res1 / res2;
		return decimalToHexa(result);
	}
	catch (ArithmeticException e){
		return "Number should not be divided by zero";	
	}
}

public static String multiplication(String num1, String num2){
	long res1 = hexaToDecimal(num1); 
	long res2 = hexaToDecimal(num2);
	long result = res1 * res2;
	return decimalToHexa(result);
}

//TO COVERT THE HEXADECIMAL NUMBER INTO DECIMAL NUMBER
public static long hexaToDecimal(String num){
	long quotient = 0, value = 0, result = 0;
	
	for(int loop = num.length()-1; loop >= 0; loop--){
		char ch = num.charAt(loop);							
		value = hexadecimalNumber.indexOf(ch);										
		result += value * pow(16,quotient);			
		quotient++;		
	}
	return result;
}

//TO CONVERT DECIMAL NO. TO HEXADECIMAL NO.
public static String decimalToHexa(long decimal){
	String hexa = "";
	long remainder;
	long hexaLimit = 16;
	
	if(decimal < 0){
		hexa += "-";
	}
	decimal = Math.abs(decimal);
	do{	
		remainder = decimal % hexaLimit;
		char ch = hexadecimalNumber.charAt((int)remainder);
		decimal = decimal / hexaLimit;
		hexa += Character.toString(ch);
	} while(decimal > 0);	
	return hexa;
}

//TO FIND THE POWER OF BASE NO. OF POWER power
public static long pow(long base, long power){
	long result=1;
	
	if(power == 0){
		return 1;
	}
	else if(power == 1){
		return base;
	}
	else{
		while(power != 0){
			result = result*base;
			power--;
		}
	}
	return result;
}

//check that the numbers are equal or not
public static boolean equalsTo(String num1,String num2){
	if (hexaToDecimal(num1) == hexaToDecimal(num2)){
		return true;
	}
	else {
		return false;
	}
}

//to check which number is greater
public static boolean greater(String num1, String num2){
	if(hexaToDecimal(num1) > hexaToDecimal(num2)){
		return true;
	}
	else {
		return false;
	}
}

//to check th smaller number
public static boolean smaller(String num1, String num2){
	if(hexaToDecimal(num1) < hexaToDecimal(num2)){
		return true;
	}
	else {
		return false;
	}
}
}
