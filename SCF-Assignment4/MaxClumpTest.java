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
	public int result;
	
	public MaxClumpTest(int[] array, int result) {
		super();
		this.array = array;
		this.result = result;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{     
					{new int[] {1, 2, 2, 3, 4, 4}, 2},
					{new int[] {1, 1, 2, 1, 1}, 2},
					{new int[] {1, 1, 1, 1, 1}, 1},
					}); 
	}
	
	@Test
	public void testPositive() {
		assertEquals(result, ArrOperation.clumps(array));	
	}
	
	@Test(expected = AssertionError.class)
	public void emptyError(){
		int[] input = {};
		ArrOperation.longestMirror(input);
	}
		
}