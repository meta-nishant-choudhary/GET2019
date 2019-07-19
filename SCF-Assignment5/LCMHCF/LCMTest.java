package LCMHCF;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LCMTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList ((new Object [][] {
			{new int[] {12, 30}, 60},
			{new int[] {30, 45}, 90}
		}));
	}
	
	private int[] inputNumbers;
	private int expected;
	
	public LCMTest(int[] input, int expected){
		this.inputNumbers = input;
		this.expected = expected;
	}
	
	//Positive Test Case
	@Test
	public void lcmTest() {
		try {
			assertEquals(expected,MathematicalOp.lcm(inputNumbers[0], inputNumbers[1]));
		}catch(Exception exception) {
			exception.getStackTrace();
		}
	}
	
	// Negative Test Case
		// divide by zero
	@Test(expected = ArithmeticException.class)
	public void lcmDivideByZeroTest(){
		assertEquals(2,MathematicalOp.lcm(0,inputNumbers[1]));
	}
	
	// negative Number
	@Test(expected = AssertionError.class)
	public void lcmNegativeNumber(){
		assertEquals(2,MathematicalOp.lcm(-1,4));
	}
	
}