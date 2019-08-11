package BST.test;

public class Value {
	String key;
	Long value;
	
	Value(String key, Long value) {
		try {
			this.key = key;
			this.value = value;
		}
		catch(Exception e) {
			System.out.println("Wrong input in Value");
			System.exit(0);
		}
	}
	
	public String getKey() {
		return this.key;
	}
	
	public Long getValue() {
		return this.value;
	}
}
