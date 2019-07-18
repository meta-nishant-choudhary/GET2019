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
public class FitXYPositiveTest {
	public int[] array;
	public int[] result;
	public int x;
	public int y;
	
	
	
	public FitXYPositiveTest(int[] array, int[] result, int x, int y) {
		super();
		this.array = array;
		this.result = result;
		this.x = x;
		this.y = y;
		
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{     
					{new int[]{5, 4, 9, 4, 9, 5}, new int[]{9, 4, 5, 4, 5, 9}, 4, 5,},
					{new int[]{1, 4, 1, 5}, new int[]{1, 4, 5, 1}, 4, 5},
					{new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5}, 4, 5},
					{new int[]{},new int[]{0},4,5},
		});
	}
	
	@Test
	public void testPositive(){
			Assert.assertArrayEquals(result, ArrOperation.fitXY(array, x, y));
	}
}
	
