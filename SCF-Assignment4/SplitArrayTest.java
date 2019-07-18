package com.metacube;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SplitArrayTest {
	public int[] array;
	public int negativeResult;
	public int positiveResult;
	
	public SplitArrayTest(int[] array, int positiveResult, int negativeResult ) {
		super();
		this.array = array;
		this.negativeResult = negativeResult;
		this.positiveResult = positiveResult;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{     
					{new int[]{1, 1, 1, 2, 1}, 3, 1},
					{new int[]{2, 1, 1, 2, 1}, -1, 2},
					{new int[]{10, 10}, 1, 2},
					{new int[] {},0,1},
		}); 
	}
	
	@Test
	public void testPositive(){
		assertEquals(positiveResult, ArrOperation.splitArray(array));	
	}
	

	@Test
	public void testNegative(){
		Assert.assertNotEquals(negativeResult,ArrOperation.splitArray(array) );
	
}
}
