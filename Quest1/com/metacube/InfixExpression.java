package Quest1.com.metacube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InfixExpression {
	
	
	public static Integer evaluateString(String expression){
		
		String array[] = expression.split(" ");
		Stack<Integer> operands = new Stack<Integer>();
		Stack<String> operators = new Stack<String>();
		Integer length=array.length;
		for(int loop=0;loop<length;loop++){
			try{
				Integer number = Integer.parseInt(array[loop]);
				operands.push(number);
				
			}catch(Exception ex){
				if(array[loop].equalsIgnoreCase("(")){
					operators.push(array[loop]);
				}
				else if(array[loop].equalsIgnoreCase(")")){
					while(!operators.getTop().equalsIgnoreCase("(")){
						Integer value = Calculate(operands.pop(),operands.pop(), operators.pop());
						operands.push(value);
					}
					operators.pop();					
				}
				else{
					
					while(!operators.isEmpty() && checkPrecedence(array[loop],operators.getTop()) && !operands.isEmpty()){
						Integer value = Calculate(operands.pop(),operands.pop(), operators.pop());
						operands.push(value);
					}
					operators.push(array[loop]);
				}
			}
		}
		
		while(!operators.isEmpty()){
			Integer value = Calculate(operands.pop(),operands.pop(), operators.pop());
			operands.push(value);
		}
		return operands.pop();		
	}
	
	
	private static Integer Calculate(Integer number2, Integer number1, String operand){
		if(operand.equalsIgnoreCase("+"))
			return number1+number2;
		else if(operand.equalsIgnoreCase("-"))
			return number1-number2;
		else if(operand.equalsIgnoreCase("*"))
			return number1*number2;
		else if(operand.equalsIgnoreCase("/"))
			return number1/number2;
		else if(operand.equalsIgnoreCase(">")){
			if(number1>number2)
				return 1;
			else
				return 0;
		}
		else if(operand.equalsIgnoreCase("<")){
			if(number1<number2)
				return 1;
			else
				return 0;
		}
		else if(operand.equalsIgnoreCase("==")){
			if(number1==number2)
				return 1;
			else
				return 0;
		}
		else if(operand.equalsIgnoreCase("!=")){
			if(number1!=number2)
				return 1;
			else
				return 0;
		}
		else if(operand.equalsIgnoreCase("&&")){
			if(number1!=0 && number2!=0){
				return 1;
			}
			else
				return 0;
		}
		else if(operand.equalsIgnoreCase("||")){
			if(number1!=0 || number2!=0){
				return 1;
			}
			else
				return 0;
		}
			
		return 0;
	}
	
	private static boolean checkPrecedence(String operand1,String operand2){
		 List<String> arithmetic = new ArrayList<String>(Arrays.asList("+","-","*","/"));
		 List<String> relational = new ArrayList<String>(Arrays.asList("==","!=",">","<",">=","<="));
		 List<String> bool = new ArrayList<String>(Arrays.asList("&&","||","!"));
		 
		 if (operand2.equalsIgnoreCase("(") || operand2.equalsIgnoreCase(")"))
			 return false;
		 if(arithmetic.contains(operand1)){
			 	if(relational.contains(operand2) || bool.contains(operand2))
			 		return false;
			 	else{
			 		if ((operand1.equals("*") || operand1.equals("/")) && (operand2.equals("+") || operand2.equals("-"))) 
			            return false; 
			        else
			            return true;
			 	}
			 	 
		 }
		 else if(relational.contains(operand1)){
			 if(arithmetic.contains(operand2))
				 return true;
			 else if(bool.contains(operand2))
				 return false;
			 else{
				 if ((operand1.equalsIgnoreCase("<") || operand1.equalsIgnoreCase("<=") || operand1.equalsIgnoreCase(">") || operand1.equalsIgnoreCase(">=")) && (operand2.equalsIgnoreCase("==") || operand2.equalsIgnoreCase("!="))) 
			            return false; 
			        else
			            return true;
			 }
		 }
		 else{
			 if(bool.contains(operand2)){
				 return false;
			 }
			 else
				 return true;
		 }
		  
	             
	         
	}

}
