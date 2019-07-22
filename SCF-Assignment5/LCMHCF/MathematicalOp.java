package LCMHCF;

public class MathematicalOp {
	
	/**
	 * finds the lcm of two numbers 
	 * @param smallerNumber
	 * @param largerNumber
	 * @return LCM
	 * 
	 */
	public static int lcm(int smallerNumber,int largerNumber) {
		if(smallerNumber < 0 || largerNumber < 0){
			throw new AssertionError();
		}
		return (smallerNumber * largerNumber) / GCD(smallNumber, largerNumber);
	}
	
	/**
	 * Find HCf
	 * @param a type: int
	 * @param b type: int
	 * @return HCF type: int
	 */
	public static int GCD (int a, int b) {
		a = Math.max(a, b);
		b = Math.min(a, b);
		
		if ( a == 0 ) {
			return b;
		}
		else if ( b == 0 ) {
				return a;
		}
		else {
			return GCD(b, a % b);
		}
	}
}
