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
	public int result;
	
	public MaxMirrorTest(int[] array, int result) {
		super();
		this.array = array;
		this.result = result;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{     
					{new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3},
					{new int[]{7, 1, 4, 9, 7, 4, 1}, 2},
					{new int[]{1, 2, 1, 4}, 3},
					}); 
	}
	
	@Test
	public void test(){     
		assertEquals(result, ArrOperation.longestMirror(array));
	}
	
	@Test(expected = AssertionError.class)
	public void emptyError(){
		int[] input = {};
		ArrOperation.longestMirror(input);
	}
}
