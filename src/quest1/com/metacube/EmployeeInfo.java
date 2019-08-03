package quest1.com.metacube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeInfo {
	public static ArrayList<Employee> employee = new ArrayList<Employee>();
	
	public static boolean addEmployee( Integer[] empId, String[] empName, String[] empAddress ) {
		if(empId == null || empName == null || empAddress == null) {
			throw new AssertionError("input cannot be null");
		}
		if (empId.length < 5 && empId.length != empName.length && empId.length != empAddress.length) {
			throw new AssertionError("inputs should be equal or cannot be less than 5");
		}
		for(int i = 0; i < empId.length; i++) {
			Employee empObj = new Employee(empId[i], empName[i], empAddress[i]);
			for(Employee emp : employee){
				if(emp.getId() != empId[i]){
					continue;
				}
				else{
					throw new AssertionError("Employee should be unique");
				}
			}
			employee.add(empObj);
		}
		return true;
	}
	
	public static boolean sortEmloyeeListById() {
		Collections.sort(employee, new Comparator<Employee>() {
			
		    public int compare(Employee e1, Employee e2) {
		    	return Integer.valueOf(e1.getId()).compareTo(e2.getId());
		    }
		});
		return true;
	}
	
	public static boolean sortEmployeeListByName() {
		Collections.sort(employee, new Comparator<Employee>() {
			
		    public int compare(Employee e1, Employee e2) {
		    	return e1.getName().compareTo(e2.getName());
		    }
		});
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] id = {4,2,1,3,5};
		String[] name = {"Nishant", "Abhishek", "revak", "harshit", "Pranshu"};
		String[] Address = {"Ghar 1", "Ghar 2", "Ghar 3", "Ghar 4", "Ghar 5"};
		addEmployee(id, name, Address);
		
		sortEmployeeListByName();
	}
	
}
