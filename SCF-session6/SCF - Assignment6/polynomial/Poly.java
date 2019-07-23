package polynomial;
import java.util.List;
import java.util.ArrayList;

final class Poly {
	private int[] coff;
	private int[] deg;
	public int cofficient;
	public int degrees;
	public final double x = 2;

	public static List<Poly> lst = new ArrayList<Poly>();

	public Poly(int[] input1, int[] input2) {
		this.coff = input1;
		this.deg = input2;
	}

	public Poly(int input1, int input2) {
		this.cofficient = input1;
		this.degrees = input2;
	}
	/**
	 * to evaluate the value from expression
	 * @param x type:double
	 * @return result type: double
	 */
	public double evaluate( double x ) {
		double eval = 0;
		for(Poly elem : lst) {
			if (elem.cofficient != 0) {
				eval += elem.cofficient * Math.pow(x, elem.degrees);
			}
		}
		return eval;
	}
	/**
	 * to find the degree of expression 
	 * @return max type: int
	 */
	public int degree() {
		int max = this.deg[0];
		for(int d : this.deg ) {
			if(max < d) {
				max = d;
			}
		}
		return max;
	}
	
	/**
	 * to add two poly
	 * @param p1 type: class type
	 * @param p2 type: class type
	 * @return result type: double
	 */
	public double addPoly(Poly p1, Poly p2) {

		for(int i = 0; i < p1.coff.length; i++) {
			if(p1.coff[i] == 0){
				throw new AssertionError();
			}
			else {
				Poly obj = new Poly(p1.coff[i], p1.deg[i]);
				lst.add(obj);
			}
		}

		for(int i = 0; i < p2.coff.length; i++) {
			if(p2.coff[i] == 0){
				throw new AssertionError();
			}

			if (lst.contains(p2.deg[i])) {
				Poly obj = new Poly(p1.coff[i] + p2.coff[i], p2.deg[i]);
				lst.set(i, obj);
			}

			else{
				Poly obj = new Poly(p2.coff[i], p2.deg[i]);
				lst.add(obj);
			}
		}

		return evaluate(this.x);
	}
	
	/**
	 * to multiply two poly
	 * @param p1 type: class type
	 * @param p2 type: class type
	 * @return multiplication type: double
	 */
	public double multiplyPoly(Poly p1, Poly p2) {
		lst.clear();
		for(int i = 0; i < p1.coff.length; i++) {
			for(int j = 0; j < p2.coff.length; j++) {
				Poly obj = new Poly(p1.coff[i] * p2.coff[j], p1.deg[i] + p2.deg[j]);
				lst.add(obj);
			}
		}
		return evaluate(this.x);
	}
}