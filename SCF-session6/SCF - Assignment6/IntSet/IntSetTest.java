package com.metacube;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class IntSetTest {
	@Test
	public void isMember() {
		int[] input = { 1, 2, 3, 4, 5, 5, 5, 5 };
		IntSet set = new IntSet(input);
		assertEquals(true, set.isMember(3));
	}

	@Test
	public void sizeTest() {
		int[] input = { 1, 2, 3, 4, 5, 5, 6, 5 };
		IntSet set = new IntSet(input);
		assertEquals(6, set.size());
	}

	@Test
	public void subset() {
		int[] input1 = { 1, 2, 3, 4, 5, 5, 6, 5 };
		int[] input2 = { 2, 3, 4, 6, 4 };
		IntSet set = new IntSet(input1);
		IntSet subSet = new IntSet(input2);
		assertEquals(true, set.isSubSet(subSet));
	}

	@Ignore
	public void compliment() {
		int[] input1 = { 1, 2, 3, 4, 5 };
		IntSet set = new IntSet(input1);
		IntSet complimentSet = set.getCompliment();

	}

	@Ignore
	public void union() {
		int[] input1 = { 1, 2, 3, 4, 5 };
		int[] input2 = { 3, 3, 2, 6, 8, 6 };
		IntSet set1 = new IntSet(input1);
		IntSet set2 = new IntSet(input2);
		IntSet.union(set1, set2);

	}

	@Test(expected = AssertionError.class)
	public void checkRange() {
		int[] input = { 12, 1002 };
		IntSet set = new IntSet(input);
	}

}
