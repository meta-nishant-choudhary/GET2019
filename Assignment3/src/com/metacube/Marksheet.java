package com.metacube;

import java.util.*;

public class Marksheet {
	public Integer id;
	public Integer grades;
	
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGrades() {
		return grades;
	}

	public void setGrades(Integer grades) {
		this.grades = grades;
	}

	/**
	 * to check average
	 * @param studentGrade
	 * @return average
	 */
	public  double average(List<Marksheet> studentGrade){
		double totalMarks = 0;
		double passed = 0;
		for(Marksheet obj : studentGrade){
			totalMarks += obj.grades;
		}
		try {
			passed = totalMarks/studentGrade.size();
		}
		catch (ArithmeticException e) {
			System.out.println("cannot divide by zero");
		}
		return passed;
	}

	/**
	 * to find the maximum of grades
	 * @param studentGrade
	 * @return max
	 */
	public int maxGrade(List<Marksheet> studentGrade){
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
	public int minGrade(List<Marksheet> studentGrade){
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
	 * @param studentGrade
	 * @return
	 */
	public double studentsPassed(List<Marksheet> studentGrade){
		double passed = 0;
		for(Marksheet mark : studentGrade){
			if(mark.grades >= 40){
				passed += 1;
			}
		}
		return 100*(passed/studentGrade.size());
	}
}

