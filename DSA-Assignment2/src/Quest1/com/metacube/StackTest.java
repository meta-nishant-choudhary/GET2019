package Quest1.com.metacube;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

	@Test
	public void checkExpressionForArithmeticTest(){
		Assert.assertEquals((Integer)InfixExpression.evaluateString("3 * 4 + ( 5 * 2 )"),(Integer) 22);
	}
	
	@Test
	public void checkExpressionForRelationalTest(){
		Assert.assertEquals((Integer)InfixExpression.evaluateString("3 * 4 + ( 5 * 2 ) > 23"),(Integer) 0);
	}
	
	@Test
	public void checkExpressionBooleanTest(){
		Assert.assertEquals((Integer)InfixExpression.evaluateString("3 * 4 < ( 5 * 2 ) && 23"),(Integer) 0);
	}
	
	@Test
	public void checkPopForUnderFlow(){
		String expected = "Stack is empty";
		try {
			InfixExpression.evaluateString("");
			Stack stack = new Stack();
			stack.pop();
		}
		catch (Throwable ex){
			Assert.assertEquals(expected, ex.getMessage());
		}
	}
}
