package Quest1.com.metacube;

public class Node<T> {
	
	T data;
	Node<T> next;

	public Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}


}
