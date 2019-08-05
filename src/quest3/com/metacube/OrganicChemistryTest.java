package quest3.com.metacube;

import static org.junit.Assert.*;

import org.junit.Test;

import quest2.com.metacube.Unique;

public class OrganicChemistryTest {
	@Test
	public void checkForCorrectInputs() {
		String formula = "C(OH)";
		Integer expected = 29;
		assertEquals(expected, OrganicChemistry.caluclateMass(formula));
	}
	
	@Test
	public void checkForEmptyInputTest() {
		String formula = "";
		String expected = "String is empty";
		try {
			 OrganicChemistry.caluclateMass(formula);
		}
		catch (Throwable ex){
			assertEquals(expected, ex.getMessage()); 
		}
	}
	
	@Test
	public void checkForNullInputTest() {
		String formula = "";
		String expected = "String is null";
		try {
			 OrganicChemistry.caluclateMass(formula);
		}
		catch (Throwable ex){
			assertEquals(expected, ex.getMessage()); 
		}
	}
}
