package Quest1.com.metacube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InfixExpression {
	
	/**
	 * given expression is splits into operator and operands
	 * @param expression type: String
	 * @return operand type: Integer
	 */
	public static Integer evaluateString(String expression) {

		String array[] = expression.split(" ");
		Stack<Integer> operands = new Stack<Integer>();
		Stack<String> operators = new Stack<String>();
		Integer length = array.length;
		for (int loop = 0; loop < length; loop++) {
			try {
				Integer number = Integer.parseInt(array[loop]);
				operands.push(number);

			} catch (Exception ex) {
				if (array[loop].equals("(")) {
					operators.push(array[loop]);
				} else if (array[loop].equals(")")) {
					while (!operators.getTop().equals("(")) {
						Integer value = Calculate(operands.pop(), operands.pop(), operators.pop());
						operands.push(value);
					}
					operators.pop();
				} else {

					while (!operators.isEmpty() && checkPrecedence(array[loop], operators.getTop()) && !operands.isEmpty()) {
						Integer value = Calculate(operands.pop(), operands.pop(), operators.pop());
						operands.push(value);
					}
					operators.push(array[loop]);
				}
			}
		}

		while (!operators.isEmpty()) {
			Integer value = Calculate(operands.pop(), operands.pop(), operators.pop());
			operands.push(value);
		}
		return operands.pop();
	}

	/**
	 * calculate the operations on operands with operator
	 * @param number2
	 * @param number1
	 * @param operand
	 * @return
	 */
	private static Integer Calculate(Integer number2, Integer number1,
			String operand) {
		if (operand.equals("+"))
			return number1 + number2;
		else if (operand.equals("-"))
			return number1 - number2;
		else if (operand.equals("*"))
			return number1 * number2;
		else if (operand.equals("/"))
			return number1 / number2;
		else if (operand.equals(">")) {
			if (number1 > number2)
				return 1;
			else
				return 0;
		} else if (operand.equals("<")) {
			if (number1 < number2)
				return 1;
			else
				return 0;
		} else if (operand.equals("==")) {
			if (number1 == number2)
				return 1;
			else
				return 0;
		} else if (operand.equals("!=")) {
			if (number1 != number2)
				return 1;
			else
				return 0;
		} else if (operand.equals("&&")) {
			if (number1 != 0 && number2 != 0) {
				return 1;
			} else
				return 0;
		} else if (operand.equals("||")) {
			if (number1 != 0 || number2 != 0) {
				return 1;
			} else
				return 0;
		}

		return 0;
	}
	
	/**
	 * check the precedency of the operators over other operator
	 * @param operand1 type: String
	 * @param operand2 type: String
	 * @return boolean
	 */
	private static boolean checkPrecedence(String operand1, String operand2) {
		List<String> arithmetic = new ArrayList<String>(Arrays.asList("+", "-", "*", "/"));
		List<String> relational = new ArrayList<String>(Arrays.asList("==", "!=", ">", "<", ">=", "<="));
		List<String> bool = new ArrayList<String>(Arrays.asList("&&", "||", "!"));

		if (operand2.equals("(") || operand2.equals(")"))
			return false;
		else if (arithmetic.contains(operand1)) {
			if (relational.contains(operand2) || bool.contains(operand2))
				return false;
			else {
				if ((operand1.equals("*") || operand1.equals("/")) && (operand2.equals("+") || operand2.equals("-")))
					return false;
				else
					return true;
			}

		} else if (relational.contains(operand1)) {
			if (arithmetic.contains(operand2))
				return true;
			else if (bool.contains(operand2))
				return false;
			else {
				if ((operand1.equals("<") || operand1.equals("<=") 
						|| operand1.equals(">") || operand1.equals(">="))
						&& 
						(operand2.equals("==") || operand2.equals("!=")))
					return false;
				else {
					return true;
				}
			}
		} 
		else {
			if (bool.contains(operand2)) {
				return false;
			} else
				return true;
		}
	}
}