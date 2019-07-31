package Qustion3;

import java.util.List;

public class Term {
	
	Integer coeff;
	List<Variable> variables;
	
	public Term(Integer coeff, List<Variable> variables) {
		super();
		if(variables == null){
			throw new AssertionError();
		}
		try {
			this.coeff = coeff;
			this.variables = variables;
		}
		catch (Exception e) {
			throw new AssertionError();
		}
	}
	
	

}
