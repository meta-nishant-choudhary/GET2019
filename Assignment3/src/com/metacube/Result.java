package com.metacube;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {
	
	public static void main(String[] args) {
		List<Marksheet> studentGrade = new ArrayList<Marksheet>();
		Scanner input = new Scanner(System.in);
		int numberOfStudents = 0, id = 0, marks = 0, flag = 0;
		
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
				System.out.println("Wrong input. please enter coorect students number");
			}
		} while (flag == 0);
		
		//To check the inputs are valid
		flag=0;
		for(int loop = 0; loop < numberOfStudents; loop++){
			//check first number is valid
			do {
				System.out.println("Enter student id: ");
				try {
					id = input.nextInt();
					flag = 1;
				}
				catch (ArithmeticException e) {
					System.out.println("wrong input");
					loop--;
					continue;
				}
			} while (flag == 0);
			
			if (id < 1) {
			System.out.println("Wrong input");
			--loop;
			continue;
			}
			//check the second number is valid
			flag=0;
			do {
				System.out.println("Enter student marks: ");
				try {
					marks = input.nextInt();
					flag=1;
				}
				catch (ArithmeticException e) {
					System.out.println("wrong input");
					--loop;
					continue;
				}
			} while (flag == 0);
			
			if((marks < 0 || marks > 100) || id < 1){
				System.out.println("Wrong input");
				--loop;
				continue;
			}
			else{
				System.out.println("marks "+marks);
				Marksheet obj1 = new Marksheet();
				System.out.println("obj "+obj1);
				obj1.setGrades(marks);
				obj1.setId(id);
				studentGrade.add(obj1);
			}
		}
		Marksheet result = new Marksheet();
		System.out.println("Avg: " + String.format("%.2f", result.average(studentGrade)));
		System.out.println("MAX: " + result.maxGrade(studentGrade));
		System.out.println("MIN: " + result.minGrade(studentGrade));
		System.out.println("Pass: " + result.studentsPassed(studentGrade));
		}
	}

