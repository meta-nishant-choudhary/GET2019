package com.metacube.util;

public class DBQueries {
	public static String INSERT = "insert into inventory values(?, ?);";
	
	public static String UPDATE = "update inventory set quantity=? where name=?;";
	
	public static String UPDATEALL = "update inventory name=?, quantity=? where name=?;";
	
	public static String DELETEALL = "delete from inventory";
	
	public static String DELETE = "delete from inventory where name=?";
	
	public static String GETALL = "select * from inventory;";
	
	public static String GETNAME = "select * from inventory where name=?";
}
