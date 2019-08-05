package quest2.com.meta;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class EmployeeTest {

	@Test
	public void correctInputTest() {
		Employee[] employee = new Employee[] {
				new Employee(1, 40000, 24),
				new Employee(2, 40000, 23),
				new Employee(3, 40000, 22),
				new Employee(4, 40000, 21),
		};
		Employee[] expected = {employee[3], employee[2], employee[1], employee[0]};
		Assert.assertArrayEquals(expected, Employee.insertionSort(employee));
	}
	
	@Test
	public void nullInputInsertionSortTest() {
		Employee[] employee = null;
		String expected = "null employee";
		try {
			Employee.insertionSort(employee);
			fail();
		}
		catch (Throwable ex){
			assertEquals(expected, ex.getMessage());
		}
	}
	
	@Test
	public void emptyInputInsertionSortTest() {
		Employee[] employee = {};
		String expected = "empty employee";
		try {
			Employee.insertionSort(employee);
			fail();
		}
		catch (Throwable ex){
			assertEquals(expected, ex.getMessage());
		}
	}
}
