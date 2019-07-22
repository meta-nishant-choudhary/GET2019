package com.metacube;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MaxMirrorTest {
	
	public int[] array;
	public int negativeResult;
	public int positiveResult;
	
	public MaxMirrorTest(int[] array, int negativeResult, int positiveResult) {
		super();
		this.array = array;
		this.negativeResult = negativeResult;
		this.positiveResult = positiveResult;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{     
					{new int[]{1,2,3,8,9,3,2,1}, 3, 2},
					{new int[]{7, 1, 4, 9, 7, 4, 1}, 2, 7},
					{new int[]{1, 2, 1, 4}, 3, 4},
					{new int[] {},0,1},
		}); 
	}
	
	@Test
	public void testNegative(){
		assertEquals(negativeResult, ArrOperation.longestMirror(array));
		
	}
	
	@Test
	public void testPositive(){
		assertNotEquals(positiveResult, ArrOperation.longestMirror(array));
		
	}
}
