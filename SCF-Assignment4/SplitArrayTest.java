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
	public int result;

	public SplitArrayTest(int[] array, int result) {
		super();
		this.array = array;
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 1, 1, 2, 1 }, 3 },
				{ new int[] { 2, 1, 1, 2, 1 }, -1 },
				{ new int[] { 10, 10 }, 1 }
					
				});
	}

	@Test
	public void test() {
		assertEquals(result, ArrOperation.splitArray(array));
	}

	@Test(expected = AssertionError.class)
	public void emptyError() {
		int[] input = {};
		ArrOperation.longestMirror(input);
	}
}
