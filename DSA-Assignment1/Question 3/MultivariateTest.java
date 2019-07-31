package Qustion3;

import org.junit.Assert;
import org.junit.Test;

public class MultivariateTest {
	
	/**
	 * to check the input list give correct max degree output
	 */
	@Test
	public void FindDegreeWithCorrectInput() {
		MultivariantPolynomial poly= new MultivariantPolynomial(new Integer[]{1,2,1,-6,3,12,3,12,12});
		Assert.assertEquals((Integer)24, (Integer)poly.FindDegree() );
	}
	
	/**
	 * to check if input array is null
	 */
	@Test(expected = AssertionError.class)
	public void FindDegreeWithWrongInput1() {
		MultivariantPolynomial poly= new MultivariantPolynomial(null);
	}
}
