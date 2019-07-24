package polynomial;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class PolyTest {

	@Test
	public void evaluateTest() {
		Integer[] coff = { 2, 2, 2 };
		Integer[] deg = { 1, 2, 3 };
		Poly p = new Poly(coff, deg);

		double res = 28.0;
		double val = 2.0;

		assertEquals(res, p.evaluate(val), 2);
	}

	@Test
	public void addPolyTest() {
		Integer[] coff1 = { 2, 2, 2 };
		Integer[] deg1 = { 1, 2, 3 };

		Integer[] coff2 = { 3, 3, 3 };
		Integer[] deg2 = { 1, 2, 3 };

		Poly p1 = new Poly(coff1, deg1);
		Poly p2 = new Poly(coff2, deg2);

		Integer rescoeff[] = { 5, 5, 5 };
		Integer resdeg[] = { 1, 2, 3 };

		Poly p3 = Poly.addPoly(p1, p2);

		for (int loop = 0; loop < coff1.length; loop++) {
			assertEquals(rescoeff[loop], p3.coff[loop]);
			assertEquals(resdeg[loop], p3.deg[loop]);
		}
	}

	@Test
	public void multiplyPolyTest() {
		Integer[] coff1 = { 2, 2, 2 };
		Integer[] deg1 = { 1, 2, 3 };

		Integer[] coff2 = { 3, 3, 3 };
		Integer[] deg2 = { 1, 2, 3 };

		Integer rescoeff[] = { 6,12,18,12,6 };
		Integer resdeg[] = { 2, 3, 4, 5, 6 };

		Poly p1 = new Poly(coff1, deg1);
		Poly p2 = new Poly(coff2, deg2);
		
		Poly p3 = p1.multiplyPoly(p1, p2);
		
		for (int loop = 0; loop < coff1.length; loop++) {
			System.out.println(p3.coff[loop]);
			assertEquals(rescoeff[loop], p3.coff[loop]);
			assertEquals(resdeg[loop], p3.deg[loop]);
		}
	}

	@Test(expected = AssertionError.class)
	public void zeroCofficient() {
		Integer[] coff = { 0, 2, 2 };
		Integer[] deg = { 1, 2, 3 };
		Poly p = new Poly(coff, deg);
		try{
			p.evaluate(2);
		}
		catch (AssertionError e) {
			assertEquals("Wrong input",p.evaluate(2));
		}
	}
}
