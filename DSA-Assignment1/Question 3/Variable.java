package Qustion3;

public class Variable {
	
	Character var;
	Integer power;
	
	public Variable(Character var, Integer power) {
		super();
		if(!Character.isLetter(var)) {
			throw new AssertionError();
		}
		
		try {
			this.var = var;
			this.power = power;
		}
		catch (Exception e) {
			throw new AssertionError();
		}
	}
	
	
	
}
