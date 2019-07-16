package com.metacube;

import java.util.*;

public class Marksheet {
	private int id;
	private int grades;

		void setGrades(int marks){
			this.grades = marks;
		}

		int getGrades(){
			return this.grades;
		}

		void setId(int id){
			this.id = id;
		}

		int getId(){
			return this.id;
		}

	public static void main(String[] args) {
		Marksheet marksheet = new Marksheet();
		List<Marksheet> studentGrade = new ArrayList<Marksheet>();
		Scanner input = new Scanner(System.in);
		int numberOfStudents, id, marks;

		System.out.println("Enter the number of Students: ");
		numberOfStudents = input.nextInt();
		//To check the inputs are valid
		for(int loop = 0; loop < numberOfStudents; loop++){
			System.out.println("Enter student id: ");
			id = input.nextInt();
			
			System.out.println("Enter student marks: ");
			marks = input.nextInt();
			
			if((marks < 0 || marks > 100) || id < 1){
				System.out.println("Wrong input");
				--loop;
				continue;
			}
			else{
				Marksheet obj1 = new Marksheet();
				obj1.setGrades(marks);
				obj1.setId(id);
				studentGrade.add(obj1);
			}
			
			
		}

		System.out.println("Avg: " + String.format("%.2f",marksheet.average(studentGrade)));
		System.out.println("MAX: " + marksheet.maxGrade(studentGrade));
		System.out.println("MIN: " + marksheet.minGrade(studentGrade));
		System.out.println("Pass: " + marksheet.studentsPassed(studentGrade));
	}
	/**
	 * to check average
	 * @param studentGrade
	 * @return average
	 */
	double average(List<Marksheet> studentGrade){
		double totalMarks = 0;
		
		for(Marksheet obj : studentGrade){
			totalMarks += obj.grades;
		}
		return totalMarks/studentGrade.size();
	}

	/**
	 * to find the maximum of grades
	 * @param studentGrade
	 * @return max
	 */
	int maxGrade(List<Marksheet> studentGrade){
		int max = 0;
		for (Marksheet obj : studentGrade){
			if(obj.grades > max){
				max = obj.grades;
			}
		}
		return max;
	}
	
	/**
	 * to find minimum grade
	 * @param studentGrade
	 * @return min
	 */
	int minGrade(List<Marksheet> studentGrade){
		Marksheet obj1 = studentGrade.get(0);
		int min = obj1.grades;
		System.out.println("minimum initialize"+min);
		System.out.println("grade: " + min);
		for (Marksheet obj2 : studentGrade){
			System.out.println("hello");
			if(obj2.grades < min){
				min = obj2.grades;
				System.out.println("mingrade: " + min);
			}
		}
		return min;
	}
	
	/**
	 * to check how much students are passed
	 * @param studentGrade
	 * @return
	 */
	double studentsPassed(List<Marksheet> studentGrade){
		double passed = 0;
		for(Marksheet mark : studentGrade){
			if(mark.grades >= 40){
				passed += 1;
			}
		}
		return 100*(passed/studentGrade.size());
	}
}

