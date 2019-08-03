package quest1.com.metacube;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	@Test
	public void addEmployeeIdTest() {
		Integer[] empId = {1, 2, 3, 4, 5};
		String[] empName = {"A", "B", "C", "D", "E"};
		String[] empAddress = {"Address1", "Address2", "Address3", "Address4", "Address5",};
		
		assertTrue(EmployeeInfo.addEmployee(empId,empName, empAddress ));
	}
	
	@Test
	public void addEmployeeIdNonEqualInputArraysTest() {
		Integer[] empId = {1, 2, 3, 4};
		String[] empName = {"A", "B", "C", "D", "E"};
		String[] empAddress = {"Address1", "Address2", "Address3", "Address4", "Address5",};
		String msg = "inputs should be equal or cannot be less than 5";
		try {
			EmployeeInfo.addEmployee(empId, empName, empAddress );
		}
		catch (Throwable ex) {
			assertEquals(msg, ex.getMessage());
		}
	}
	
	@Test
	public void addSameEmployeeIdTest() {
		Integer[] empId = {1, 2, 3, 4, 2};
		String[] empName = {"A", "B", "C", "D", "E"};
		String[] empAddress = {"Address1", "Address2", "Address3", "Address4", "Address5",};
		String msg = "Employee should be unique";
		try {
			EmployeeInfo.addEmployee(empId, empName, empAddress );
		}
		catch (Throwable ex) {
			assertEquals(msg, ex.getMessage());
		}
	}
	
	@Test
	public void addNullInfoTest() {
		Integer[] empId = null;
		String[] empName = {"A", "B", "C", "D", "E"};
		String[] empAddress = {"Address1", "Address2", "Address3", "Address4", "Address5",};
		String msg = "input cannot be null";
		try {
			EmployeeInfo.addEmployee(empId, empName, empAddress );
		}
		catch (Throwable ex) {
			assertEquals(msg, ex.getMessage());
		}
	}
	
	
}
