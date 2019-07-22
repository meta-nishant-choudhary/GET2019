package LCMHCF;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HCFTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList((new Object [][] {
			{new int[] {42, 18}, 6},
			{new int[] {12, 8}, 4},
			{new int[] {10, 0}, 10}
		}));
	}
	private int[] inputNumbers;
	private int expected;
	public HCFTest(int[] input,int expected) {
		this.inputNumbers = input;
		this.expected = expected;
	}
	
	//Positive Test Case
	@Test
	public void hcfTest() {
		try {
			assertEquals(expected, MathematicalOp.GCD(inputNumbers[0], inputNumbers[1]));
		}catch(Exception exception) {
			exception.getStackTrace();
		}
	}
	
	//Negative Test Case
		// negative Number
	@Test(expected = AssertionError.class)
	public void hcfNegativeNumber() {
		assertEquals(2, MathematicalOp.GCD(-1, 4));
	}
}