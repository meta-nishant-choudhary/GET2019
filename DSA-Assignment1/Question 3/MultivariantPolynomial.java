package Qustion3;

import java.util.ArrayList;
import java.util.List;

public class MultivariantPolynomial {

	public List<Term> polynomail = new ArrayList<Term>();

	/**
	 * contructer to add variable and power to term
	 * 
	 * @param array type: array of integers
	 */
	public MultivariantPolynomial(Integer array[]) {
		super();
		if (array == null) {
			throw new AssertionError();
		}
		for (int loop = 0; loop < array.length; loop = loop + 3) {
			Variable var1 = new Variable('x', array[loop + 1]);
			Variable var2 = new Variable('y', array[loop + 2]);
			List<Variable> variable = new ArrayList<Variable>();
			variable.add(var1);
			variable.add(var2);
			Term term = new Term(array[loop], variable);
			polynomail.add(term);
		}

	}

	/**
	 * to show/print expression
	 */
	public void showPolynomial() {
		for (Term term : this.polynomail) {
			if (term.coeff < 0)
				System.out.print(term.coeff);
			else
				System.out.print("+" + term.coeff);
			for (Variable var : term.variables) {
				if (var.var == 'x')
					System.out.print("x^" + var.power);
				if (var.var.equals('y'))
					System.out.print("y^" + var.power);
			}
		}
	}

	/**
	 * to find the max degree
	 * 
	 * @return degree type: int
	 */
	public Integer FindDegree() {
		Integer degree = 0;
		for (Variable var : this.polynomail.get(0).variables) {
			degree += var.power;
		}

		for (Term term : this.polynomail) {
			Integer sum = 0;
			for (Variable var : term.variables) {
				sum += var.power;
			}
			if (sum > degree)
				degree = sum;
		}
		return degree;
	}

}
