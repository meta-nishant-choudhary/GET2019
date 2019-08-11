package quest1.com.meta;

/**
 * Node class for node property 
 * String key, value 
 *
 */
public class Node {
	
	private String key;
	private String value;
	Node left,right,parent;
	
	//constructor 
	public Node(String key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	//getter method for key
	public String getKey() {
		return key;
	}

	//setter method for key
	public void setKey(String key) {
		this.key = key;
	}

	//getter method for value
	public String getValue() {
		return value;
	}

	//setter method for value
	public void setValue(String value) {
		this.value = value;
	}

	//getter method for left child
	public Node getLeft() {
		return left;
	}

	//setter method for left child
	public void setLeft(Node left) {
		this.left = left;
	}

	//getter method right child
	public Node getRight() {
		return right;
	}

	//setter method for right
	public void setRight(Node right) {
		this.right = right;
	}

	//getter method for parent
	public Node getParent() {
		return parent;
	}

	//setter method for parent
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	
	
}
