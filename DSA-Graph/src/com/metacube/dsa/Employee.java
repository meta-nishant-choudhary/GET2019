package com.metacube.dsa;

public class Employee {
	String name;
	int age;
	double salary;

	/**
	 * Default Constructor
	 * 
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * Getter Function for name
	 * 
	 * @return Name of the Employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter Function for Age
	 * 
	 * @return Age of the Employee
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Getter Function for Salary
	 * 
	 * @return Salary of the Employee
	 */
	public double getSalary() {
		return salary;
	}
}