package com.metacube;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {
	
	public static void main(String[] args) {
		List<Marksheet> studentGrade = new ArrayList<Marksheet>();
		Scanner input = new Scanner(System.in);
		int numberOfStudents = 0, marks = 0, flag = 0;
		
		do{
			try	{
				System.out.println("Enter the number of Students: ");
				numberOfStudents = input.nextInt();
				if (numberOfStudents <= 0) {
					System.out.println("Wrong input");
					continue;
				}
				flag = 1;
			}
			catch (Exception e) {
				System.out.println("Wrong input. please enter correct students number");
				input.nextLine();
			}
		} while (flag == 0);
		
		//To check the inputs are valid
		flag=0;
		for(int loop = 0; loop < numberOfStudents; loop++){
			//check the mark is valid or not
			flag=0;
			do {
				System.out.println("Enter student marks: ");
				try {
					marks = input.nextInt();
					flag=1;
					if((marks < 0 || marks > 100)){
						System.out.println("Wrong input");
						--loop;
						System.out.println("wrong input ( marks limit: 0 to 100 )");
						continue;
					}
				}
				catch (ArithmeticException e) {
					System.out.println("wrong input ( Enter integer digit. )");
					--loop;
					continue;
				}
			} while (flag == 0);
			
			Marksheet obj1 = new Marksheet();
			obj1.setGrades(marks);
			studentGrade.add(obj1);
			
		}
		
		System.out.println("Avg: " + String.format("%.2f", Marksheet.average(studentGrade)));
		System.out.println("MAX: " + Marksheet.maxGrade(studentGrade));
		System.out.println("MIN: " + Marksheet.minGrade(studentGrade));
		System.out.println("Pass: " + Marksheet.studentsPassed(studentGrade));
	}
}

