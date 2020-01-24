package polynomial;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

final class Poly {
	public Integer[] coff;
	public Integer[] deg;

	/**
	 * constructor to initialize
	 *
	 * @param input1
	 *            type: array of integers
	 * @param input2
	 *            type: array of integers
	 **/
	public Poly(Integer[] input1, Integer[] input2) {
		for(int i = 0;i<input1.length;i++) {
			if(input1[i]==0){
				throw new AssertionError("Wrong input");
			}
		}
		this.coff = input1;
		this.deg = input2;
	}

	/**
	 * to evaluate the value from expression
	 * 
	 * @param x
	 *            type:double
	 * @return result type: double
	 */
	public double evaluate(double x) {
		double eval = 0;

		for (int loop = 0; loop < this.coff.length; loop++) {
			eval = eval + (this.coff[loop] * (Math.pow(x, this.deg[loop])));
		}
		return eval;
	}

	/**
	 * to find the degree of expression
	 * 
	 * @return max type: int
	 */
	public int degree() {
		Integer max = 0;

		for (int i = 0; i < this.deg.length; i++) {
			if (max < this.deg[i]) {
				max = this.deg[i];
			}
		}
		return max;
	}

	/**
	 * to add two poly
	 * 
	 * @param p1
	 *            type: class type
	 * @param p2
	 *            type: class type
	 * @return result type: double
	 */
	public static Poly addPoly(Poly p1, Poly p2) {
		List<Integer> addExpCoff = new ArrayList<Integer>();
		List<Integer> addExpDeg = new ArrayList<Integer>();

		int i = 0;
		int len1 = p1.coff.length;
		int len2 = p2.coff.length;
		int flag = 0;

		for (int loop = 0; loop < p1.deg.length; loop++) {
			flag = 0;
			for (int loop2 = 0; loop2 < p2.deg.length; loop2++) {
				if (p1.deg[loop] == p2.deg[loop2]) {
					addExpCoff.add(p1.coff[loop] + p2.coff[loop2]);
					addExpDeg.add(p2.deg[loop]);
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				addExpCoff.add(p1.coff[loop]);
				addExpDeg.add(p1.deg[loop]);
			}
		}

		for (int loop = 0; loop < p2.deg.length; loop++) {
			flag = 0;
			for (int loop2 = 0; loop2 < p1.deg.length; loop2++) {
				if (p1.deg[loop2] == p2.deg[loop]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				addExpCoff.add(p2.coff[loop]);
				addExpDeg.add(p2.deg[loop]);
			}
		}

		Integer[] in1 = new Integer[addExpCoff.size()];
		Integer[] in2 = new Integer[addExpDeg.size()];
		Integer lo = 0;
		for (Integer i1 : addExpCoff) {
			in1[lo] = i1;
			lo++;
		}

		lo = 0;
		for (Integer i1 : addExpDeg) {
			in2[lo] = i1;
			lo++;
		}

		Poly p = new Poly(in1, in2);

		return p;
	}

	/**
	 * to multiply two poly
	 * 
	 * @param p1
	 *            type: class type
	 * @param p2
	 *            type: class type
	 * @return multiplication type: double
	 */
	public Poly multiplyPoly(Poly p1, Poly p2) {
		List<Integer> cofficient = new ArrayList<Integer>();
		List<Integer> degree = new ArrayList<Integer>();

		for (int i = 0; i < p1.coff.length; i++) {
			for (int j = 0; j < p2.coff.length; j++) {
				cofficient.add(p1.coff[i] * p2.coff[j]);
				degree.add(p1.deg[i] + p2.deg[j]);
			}
		}
		List<Integer> co = new ArrayList<Integer>();
		List<Integer> de = new ArrayList<Integer>();

		int sizeD = degree.size();
		int sizeC = cofficient.size();
		for (int i = 0; i < sizeD; i++) {
			de.add(degree.get(i));
			co.add(cofficient.get(i));
			for (int j = i + 1; j < sizeD; j++) {
				if (de.get(i) == degree.get(j)) {
					co.set(i, co.get(i) + cofficient.get(j));
					degree.remove(j);
					cofficient.remove(j);
					sizeD--;
					j--;
				}
			}
		}

		Integer[] in1 = new Integer[cofficient.size()];
		Integer[] in2 = new Integer[degree.size()];
		Integer lo = 0;

		for (Integer i1 : co) {
			in1[lo] = i1;
			lo++;
		}

		lo = 0;
		for (Integer i1 : de) {
			in2[lo] = i1;
			lo++;
		}

		Poly p = new Poly(in1, in2);

		return p;
	}

}