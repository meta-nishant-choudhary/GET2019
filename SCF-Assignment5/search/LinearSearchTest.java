package search;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LinearSearchTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList((new Object [][] {
			{new int[] {42, 18, 3, 1, 23, 5}, 2},
			{new int[] {12, 8, 43, 2, 5}, -1},
			{new int[] {3, 45}, 0}, //lower boundary
			{new int[] {45, 4, 5, 2, 3}, 4}, //upper boundary
			
		}));
	}
	private int[] inputNumbers;
	private int expected;
	public LinearSearchTest(int[] input,int expected)  {
		this.inputNumbers = input;
		this.expected = expected;
	}
	//Positive Test Case
	@Test
	public void linearSearchTest() {
		try {
			assertEquals(expected,Search.linearSearch(inputNumbers, 3));
		}
		catch(Exception exception) {
			exception.getStackTrace();
		}
	}
}