package polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class PolyTest {

	@Test
	public void evaluateTest() {
		int[] coff = {2,2,2};
		int[] deg = {1,2,3};
		Poly p = new Poly(coff, deg);
		assertEquals((double)28, p.evaluate(2));
	}
	
	@Test
	public void addPolyTest() {
		int[] coff1 = {2,2,2};
		int[] deg1 = {1,2,3};
		int[] coff2 = {3,3,3};
		int[] deg2 = {1,2,3};
		Poly p1 = new Poly(coff1, deg1);
		Poly p2 = new Poly(coff2, deg2);
		assertEquals(70,(int)p1.addPoly(p1,p2));
	}
	
	@Test
	public void multiplyPolyTest() {
		int[] coff1 = {2,2,2};
		int[] deg1 = {1,2,3};
		int[] coff2 = {3,3,3};
		int[] deg2 = {1,2,3};
		Poly p1 = new Poly(coff1, deg1);
		Poly p2 = new Poly(coff2, deg2);
		assertEquals(1176, (int)p1.multiplyPoly(p1,p2));
	}
	
	@Test(expected = AssertionError.class)
	public void zeroCofficient() {
		int[] coff = {0,2,2};
		int[] deg = {1,2,3};
		Poly p = new Poly(coff, deg);
		p.evaluate(2);
	}
}


