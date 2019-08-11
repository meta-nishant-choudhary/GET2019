package quest1.com.meta;

/*
 * value class for containing key and value in pair
 * String key,value
 */
public class Value {
	
	private String key;
	private String value;
	
	//constructor
	public Value(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	};
	
	

}