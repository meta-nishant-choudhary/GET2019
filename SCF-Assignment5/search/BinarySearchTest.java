package search;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BinarySearchTest {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList((new Object [][] {
			{new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 4},
			{new int[] {8, 12, 43, 50, 56}, -1},
			{new int[] {10, 45}, 0},
			{new int[] {1, 3, 4, 7, 10}, 4},
			
		}));
	}
	private int[] inputNumbers;
	private int expected;
	public BinarySearchTest(int[] input,int expected) {
		this.inputNumbers = input;
		this.expected = expected;
	}
	//Positive Test Case
	@Test
	public void binarySearchTest() {
		try {
			assertEquals(expected,Search.binarySearch(inputNumbers, 10));
		}
		catch(Exception exception) {
			exception.getStackTrace();
		}
	}
	//Negative Test Case
	//assertion error if array is unsorted
	@Test(expected = AssertionError.class)
	public void testUnsorted() {
		assertEquals(expected,Search.binarySearch(new int[]{ 44, 6, 5, 1, 2, 3, 1, 5, 4}, 3));
	}
	
	

}