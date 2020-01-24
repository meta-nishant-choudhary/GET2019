package com.metacube;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class IntSet {
	private final int UPPER_BOUND = 1000;
	private final int LOWER_BOUND = 1;
	public final Integer[] set;

	public IntSet(Integer[] inputSet) {
		this.set = inputSet;
	}

	public IntSet(int[] input) {
		this.set = createSet(input);
	}

	/**
	 * create an array(or set)
	 * 
	 * @param input
	 *            : array of integers
	 * @return set type: array of integers
	 */
	private Integer[] createSet(int[] input) {
		List<Integer> listSet = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (input[i] < LOWER_BOUND || input[i] > UPPER_BOUND) {
				throw new AssertionError();
			}
			if (listSet.contains(input[i])) {
				continue;
			} else {
				listSet.add(input[i]);
			}
		}
		Integer result[] = new Integer[listSet.size()];
		return listSet.toArray(result);
	}

	/**
	 * checks whether x is present in set or not
	 * 
	 * @param x
	 *            : to be searched.
	 * @return true: if element is found else: false
	 */
	public boolean isMember(int x) {
		if (x < LOWER_BOUND || x > UPPER_BOUND) {
			return false;
		}
		for (int i = 0; i < this.set.length; i++) {
			if (x == set[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * provides the size of the set
	 * 
	 * @return size type: integer
	 */
	public int size() {
		return this.set.length;
	}

	/**
	 * checks whether a given set is a subset or not
	 * 
	 * @param subSet
	 *            type: class type IntSet
	 * @return true: if the given set is subset else: false
	 */
	public boolean isSubSet(IntSet subSet) {
		List<Integer> set = new ArrayList<Integer>(Arrays.asList(this.set));
		List<Integer> subset = new ArrayList<Integer>(Arrays.asList(subSet.set));
		if (set.containsAll(subset)) {
			return true;
		}
		return false;
	}

	/**
	 * provides the compliments of the set on which it is called.
	 * 
	 * @return complimentSet
	 */
	public IntSet getCompliment() {
		List<Integer> set = new ArrayList<Integer>(Arrays.asList(this.set));
		List<Integer> compliment = new ArrayList<Integer>();
		for (int i = LOWER_BOUND; i <= UPPER_BOUND; i++) {
			if (set.contains(i)) {
				continue;
			} else {
				compliment.add(i);
			}
		}
		Integer result[] = new Integer[compliment.size()];
		compliment.toArray(result);
		IntSet complimentSet = new IntSet(result);
		return complimentSet;
	}

	/**
	 * provides the union of to sets.
	 * 
	 * @param s1
	 * @param s2
	 * @return unionSet
	 */
	public IntSet union(IntSet s1, IntSet s2) {
		List<Integer> set1 = new ArrayList<Integer>(Arrays.asList(s1.set));
		List<Integer> set2 = new ArrayList<Integer>(Arrays.asList(s2.set));
		List<Integer> union = new ArrayList<Integer>();
		union.addAll(set1);
		
		for (int i = 0; i < set2.size(); i++) {
			if (!union.contains(set2.get(i))) {
				union.add(set2.get(i));
			}
		}
		
		Integer result[] = new Integer[union.size()];
		union.toArray(result);
		IntSet unionSet = new IntSet(result);
		return unionSet;
	}
}