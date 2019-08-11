package BST.test;

public class Node {
	String key;
	Long value;
	Node left;
	Node right;
	Node parent;
	
	public Node(String key, Long value) {
		try {
			this.key = key;
			this.value = value;
		}
		catch(Exception e) {
			System.out.println("Wrong input in Node");
			System.exit(0);
		}
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	//getter
	public String getKey() {
		return this.key;
	}
	
	public Long getValue() {
		return this.value;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	//setter
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setValue(Long value) {
		this.value = value;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
}
