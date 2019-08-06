package quest2.com.metacube;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testOfAddEmployeePositive() {
		Employee emp = new Employee();
		emp.addEmployee(1,101,21);
		assertTrue(emp.addEmployee(2,301,23));
	}
	
	@Test
	public void forSortListTestPositive() throws CloneNotSupportedException {
		Employee emp = new Employee();
		emp.addEmployee(1,101,21); 
		emp.addEmployee(2,301,24);
		emp.addEmployee(3,301,22);
		int[] id = {3, 2, 1};
		int[] salary = {301, 301, 101};
		int[] age = {22, 24, 21};
		
		Employee ep2 = new Employee();
		ep2.head =(Node) emp.clone();
		
		Node ptr = ep2.insertionSort(ep2.head);
		int i = 0;
		while(ptr != null) {
			assertEquals(ptr.getSalary(), salary[i]);
			assertEquals(ptr.getId(), id[i]);
			assertEquals(ptr.getAge(), age[i]);
			ptr = ptr.next;
			i++;
		}
	}
}
