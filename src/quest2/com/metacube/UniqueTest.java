package quest2.com.metacube;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueTest {
	
	@Test
	public void checkInputForCheckUniqueTest() {
		String strInput = "Hello";
		Integer expected = 3;
		assertEquals(expected, Unique.checkUnique(strInput));
	}
	
	@Test
	public void checkInputForEmptyInputTest() {
		String strInput = "";
		String expected = "string can't be empty";
		try {
			Unique.checkUnique(strInput);
		}
		catch (Throwable ex){
			assertEquals(expected, ex.getMessage()); 
		}
	}
	
	@Test
	public void checkInputForNullInputTest() {
		String strInput = null;
		String expected = "string can't be null";
		try {
			Unique.checkUnique(strInput);
		}
		catch (Throwable ex){
			assertEquals(expected, ex.getMessage()); 
		}
	}
}
