package com.metacube.hibernate1.util;

public class DBQueries {
	public static String INSERTEMPLOYEE = "insert into employee(Name, gender, Email, password, Contact, Organization) values(?, ?, ?, ?, ?, ?);";
	
	public static String UPDATEEMPLOYEE = "update employee set name=?, Contact=? where id=?;";
	
	public static String GETEMPLOYEE = "select * from employee;";
	
	public static String GETBYID = "select * from employee where id=?;";
	
	public static String GETLASTEMPLOYEE = "select max(id) from Employee;";
	
	public static String GETFRIEND = "select * from employee where id!=? and Organization=?;";
	
	public static String INSERTVEHICLE = "insert into vehicle(name, type, number, E_id, Identification) values(?, ?, ?, ?, ?);";
	
	public static String FETCHVEHICLE = "select max(id) from vehicle";
	
	public static String INSERTPASS = "insert into pass(E_id, type, v_id, price, plan) values(?, ?, ?, ?, ?);";
	
}
