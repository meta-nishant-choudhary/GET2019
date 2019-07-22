package com.metacube;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * check negative test cases
 * @param Null
 * @return Null
 */
@RunWith(Parameterized.class)
public class MaxClumpTest {
	public int[] array;
	public int positiveResult;
	public int negativeResult;
	
	public MaxClumpTest(int[] array, int positiveResult, int negativeResult) {
		super();
		this.array = array;
		this.positiveResult = positiveResult;
		this.negativeResult = negativeResult;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{     
					{new int[] {1, 2, 2, 3, 4, 4}, 2, 4},
					{new int[] {1, 1, 2, 1, 1}, 2, 4},
					{new int[] {1, 1, 1, 1, 1}, 1, 4},
					{new int[] {},0,1},
					}); 
	}
	
	@Test
	public void testPositive() {
		assertEquals(positiveResult, ArrOperation.clumps(array));	
	}
	
	@Test
	public void testNegative() {
		assertNotEquals(negativeResult, ArrOperation.clumps(array));
	}
		
}