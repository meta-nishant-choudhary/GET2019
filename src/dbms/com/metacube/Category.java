package dbms.com.metacube;

public class Category {

	String name;
	int numberOfChildren;

	public Category(String name, int numberOfChildren) {
		this.name = name;
		this.numberOfChildren = numberOfChildren;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
}