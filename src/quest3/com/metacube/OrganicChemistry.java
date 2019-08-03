package quest3.com.metacube;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OrganicChemistry {
	public static HashMap<Character, Integer> elements = new HashMap<Character, Integer>();

	public static Integer caluclateMass(String formula) {
		if(formula == null) {
			throw new AssertionError("String is null");
		}
		
		if(formula.length() == 0) {
			throw new AssertionError("String is empty");
		}
		
		enterElementsInMap();
		Stack<Character> bracket = new Stack<Character>();
		Stack<Integer> operands = new Stack<Integer>();
		char[] elementArray = formula.toCharArray();
		int sum = 0;

		for (char ch : elementArray) {

			if (elements.containsKey(ch)) {
				operands.add(elements.get(ch));
			} else if (ch == '(') {
				bracket.add(ch);
			} else if (ch == ')') {
				int op1 = operands.pop();
				int op2 = operands.pop();
				sum = op1 + op2;
				operands.add(sum);
				bracket.pop();
			} else {
				Integer i = Integer.parseInt(String.valueOf(ch));
				Integer op = operands.pop();
				operands.add(op * i);
			}
		}
		while (operands.size() > 1) {
			Integer operand1 = operands.pop();
			Integer operand2 = operands.pop();
			operands.add(operand1 + operand2);
		}

		return operands.pop();
	}

	public static void enterElementsInMap() {
		elements.put('C', 12);
		elements.put('O', 16);
		elements.put('H', 1);
	}

	public static void main(String[] args) {

		String formula = "C2(H(OH)2)";
		System.out.println(caluclateMass(formula));
		;
	}
}
