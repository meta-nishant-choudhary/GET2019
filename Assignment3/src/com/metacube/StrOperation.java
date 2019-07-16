package com.metacube;

import java.util.Scanner;

class StrOperation{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StrOperation obj = new StrOperation();

		int choice = 0;
		//To choose the operation
		do{
			System.out.println("\nchoose the operation you want to perform: \n"
				+ "1. compare String\n"
				+ "2. Reverse String\n"
				+ "3. Toggle\n"
				+ "4. Lonest Word\n"
				+ "0. Exit\n"
				+ "Choice: ");
			
			choice = input.nextInt();
			
			input.nextLine();
			switch (choice) {
				case 1: 
					System.out.println("Enter the first sring: ");
					String strFirst = input.nextLine();
					System.out.println("Enter the second sring: ");
					String strSecond = input.nextLine();
					
					int value = obj.compareString(strFirst, strSecond);
					if (value == 1){
						System.out.println("Strings are equal");
					}
					else {
						System.out.println("Strings are not equal");
					}
					break;
				case 2: 
					System.out.println("Enter the string you want to reverse: ");
					String forReverse = input.nextLine();
					System.out.println(obj.reverseString(forReverse));
					break;
				case 3:
					System.out.println("Enter the String you want to toggle: ");
					String toggleStr = input.nextLine();
					System.out.println(obj.toggle(toggleStr));
					break;
				case 4: System.out.println("Enter the String and find longest word: ");
						String longStr = input.nextLine();
						System.out.println(obj.largestWord(longStr));
						break;
				case 0: default:
					break;
				}
			} while ( choice != 0 ) ;
		System.out.println("Exit");
	}
	
	/**
	 * compare the strings
	 * @param strFirst
	 * @param strFirst, strSecond String inputs
	 * @return 1 if equal else return 0 
	 */
	int compareString(String strFirst, String strSecond){
		if (strFirst.length() == strSecond.length()){
			for(int loop = 0; loop < strFirst.length(); loop++){
				if (strFirst.charAt(loop) == strSecond.charAt(loop)){
					continue;
				}
				else {
					return 0;
				}
			}
			return 1;
		}
		return 0;
	}
	
	/**
	 * reverse the string 
	 * @param String str
	 * @return reversed String
	 */ 
	String reverseString(String str){
		String revStr = "";
		for(int index = str.length()-1; index >= 0; index--){
			revStr = revStr + str.charAt(index);	
		}
		return revStr;
	}
	
	/**
	 * to change uppercase letter in lower and vice-versa
	 * @param String str
	 * @return toggled String
	 */
	String toggle(String str){
		String changedStr = "";
		int ascii = 32;
		char character;
		int capitalStart = 64, capitalEnd = 91;
		int smallStart = 96, smallEnd = 122;
		for(int index = 0; index < str.length(); index++){
			int charNum = str.charAt(index);
			if (charNum > capitalStart && charNum < capitalEnd){ 
				character = (char)(charNum + ascii); 
			}
			else if (charNum > smallStart && charNum < smallEnd){
				character = (char)(charNum - ascii);  
			}
			else {
				character = (char)(charNum);
			}
			changedStr += Character.toString(character);
		}
		return changedStr;
	}
	
	/**
	 * to find the longest word in given String
	 * @param String str 
	 * @return longest word
	 */
	String largestWord(String str){
		int maxLength = 0;
		String longestWord = "";
		String []str1 = str.split(" ");
		maxLength = str1[0].length();
		
		for(String word:str1){
			if(word.length() >= maxLength){
				longestWord = "";
				maxLength = word.length();
				longestWord += word;
			}
		}
		return longestWord;
	}
}