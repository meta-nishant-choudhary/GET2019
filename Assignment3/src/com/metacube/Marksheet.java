package com.metacube;

import java.util.*;

public class Marksheet {
	public Integer grades;

	public Integer getGrades() {
		return grades;
	}

	public void setGrades(Integer grades) {
		this.grades = grades;
	}

	/**
	 * to check average 
	 * @param studentGrade type: Marksheet
	 * @return average type: double
	 */
	public static double average(List<Marksheet> studentGrade){
		double totalMarks = 0;
		double passed = 0;
		for(Marksheet obj : studentGrade){
			totalMarks += obj.grades;
		}
		try {
			passed = totalMarks / studentGrade.size();
		}
		catch (ArithmeticException e) {
			System.out.println("cannot divide by zero");
		}
		return passed;
	}

	/**
	 * to find the maximum of grades
	 * @param studentGrade type: Marksheet
	 * @return max type: integer
	 */
	public static int maxGrade(List<Marksheet> studentGrade){
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
	 * @param studentGrade type: Marksheet
	 * @return min type: integer
	 */
	public static int minGrade(List<Marksheet> studentGrade){
		Marksheet obj1 = studentGrade.get(0);
		int min = obj1.grades;
		
		for (Marksheet obj2 : studentGrade){
			if(obj2.grades < min){
				min = obj2.grades;
			}
		}
		return min;
	}
	
	/**
	 * to check how much students are passed
	 * @param studentGrade type: Marksheet
	 * @return pass type: double
	 */
	public static double studentsPassed(List<Marksheet> studentGrade){
		double passed = 0;
		double pass = 0;
		for(Marksheet mark : studentGrade){
			if(mark.grades >= 40){
				passed += 1;
			}
		}
		try {
			pass = 100 * (passed / studentGrade.size());
		}
		catch (Exception e){
			System.out.println("Can't be divide by zero");
		}
		return pass;
	}
}

