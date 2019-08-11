package BST.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class BST {
	Node head = null;
	Integer index = 0;
	//nonParameterized constructor
	BST() {
		
	}
	
	public void addTreeNode(String key, Long value) {
		BST bstNode = new BST();
		if(head == null) {
			head = new Node(key, value);
		}
		else {
			bstNode.addRec(head, key, value);
		}
	}
	
	public void addRec(Node node, String key, Long value) {
		if(node.getValue() > value) {
			if(node.getLeft() != null) {
				addRec(node.getLeft(), key, value);
			}
			else {
				node.setLeft(new Node(key, value));
				node.getLeft().setParent(node);
			}
		}
		else if(node.getValue() <= value) {
			if(node.getRight() != null) {
				addRec(node.getRight(), key, value);
			}
			else {
				node.setRight(new Node(key, value));
				node.getRight().setParent(node);
			}
		}
	}
	
	private void delete(Long value) {
		if(head == null) {
			System.out.println("tree is empty");
		}
		else{
			deleteRec(head, value);
		}
	}
	
	private void deleteRec(Node node, Long value) {
		if(value < node.getValue()){
			if(node.left != null)
				deleteRec(node.left, value);
		}
		else if(value > node.getValue()) {
				if(node.right != null)
					deleteRec(node.right, value);
			}
		else if(node.left == null && node.right == null) {
				if(node.getParent().getLeft() == node)
					node.getParent().setLeft(null);
				else {
					node.getParent().setRight(null);
				}
			}
			else if(node.left == null && node.right != null) {
				if(node.getParent().getLeft() == node) {
					node.getParent().setLeft(node.getRight());
				}
				else {
					node.getParent().setRight(node.getRight());
				}
			}
			else if(node.left != null && node.right == null) {
				if(node.getParent().getRight() == node) {
					node.getParent().setRight(node.getLeft());
				}
				else {
					node.getParent().setLeft(node.getLeft());
				}
			}
			else if(node.left != null && node.right != null) {
				Node newNode = findMin(node.right);
				node.setKey(newNode.getKey());
				node.setValue(newNode.getValue());
				deleteRec(newNode, value);
			}
	}
	
	public Node findMin(Node node) {
		while(node != null) {
			node = node.left;
		}
		return node;
	}
	
	private Value[] inorderRec(Node root, Value[] arr) {
		if (root != null) { 
			inorderRec(root.left, arr);
	        Value val = new Value(root.getKey(), root.getValue());
	        arr[index] = val;
	        index++;
	        inorderRec(root.right, arr);
	    }
		return arr;
	}
	
	public void printTree(Value[] value) {
		System.out.println("");
		for(int i = 0; i < value.length; i++) {
			System.out.println(value[i].getKey() + "\t" + value[i].getValue());
		}
	}
	
	//i use this list in this method because problem statement states that return the list
	public List<Value> getBetween(String key1, String key2, Value[] val) {
		Integer ind = 0;
		List<Value> list = new ArrayList<Value>();
		for(Value obj: val) {
			if(comparator(key1, obj.key) == -1 && comparator(key2, obj.key) == 1) {
				list.add(obj);
			}
		}
		return list;
	}
	
	public Value getPair(String key, Value[] val) {
		for(Value Obj : val) {
			if(key.equals(Obj.getKey())) {
				return Obj;
			}	
		}
		return null;
	}
	
	public Value[] sorted(Node root, Value[] arr) {
		BST bst = new BST();
		return bst.inorderRec(root, arr);
	}
	
	public Integer comparator(String key1, String key2) {
		if(key1.length() == key2.length()) {
			for(int i = 0; i < key2.length(); i++) {
				if(key1.charAt(i) == key2.charAt(i)) {
					continue;
				}
				else if (key1.charAt(i) > key2.charAt(i)) {
					return 1;
				}
				else if (key1.charAt(i) < key2.charAt(i)){
					return -1;
				}
			}
			return 0;
		}
		else if (key1.length() > key2.length()) {
			return 1;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		BST b = new BST();
		int size = 0;
		String k;
		Long v;
		try {
			FileReader file = new FileReader("data.json");
			JSONParser parser = new JSONParser ();
			JSONObject json = (JSONObject) parser.parse(file);
			JSONObject jsonObject = new JSONObject();

			for(Object obj : json.keySet()) {
				k = (String) obj;
				v = (Long)json.get(k);
				size += 1;
				b.addTreeNode(k, v);
			}
		}
		catch (Exception e) {
			System.out.println("Wrong type of input");
		}
		
		//print the value insert in the tree
		Value[] arr = new Value[size];
		Value[] val = b.inorderRec(b.head, arr);
		if(val == null || val.length == 0){
			System.out.println("empty or null return");
			System.exit(0);
		}
		System.out.println("first print");
		b.printTree(val);
		
		//delete the value and print array of remaining vale
		Long delVal = (long) 20;
		if(delVal == null){
			System.out.println("input to be deleted can't be null");
			System.exit(0);
		}
		b.delete(delVal);
		b.index = 0;
		size--;
		Value[] arr2 = new Value[size];
		Value[] val2 = b.inorderRec(b.head, arr2);
		if(val2 == null || val2.length == 0){
			System.out.println("output: empty/null");
			System.exit(0);
		}
		System.out.println("After deletion");
		b.printTree(val2);
		
		//Sorted method
		System.out.println("After deletion: ");
		val2 = b.inorderRec(b.head, arr2);
		if(val2 == null || val2.length == 0){
			System.out.println("output: empty/null");
			System.exit(0);
		}
		System.out.println("After deletion");
		b.printTree(val2);
		
		
		//print the key value pair between the keys given
		List<Value> list = b.getBetween("30", "60", val);
		System.out.println("\n: between");
		for(Value objOfValue : list) {
			System.out.println(objOfValue.key + "\t" + objOfValue.value);
		}
		
		//print the specific keys-value pair given to the method
		System.out.println("\nspecific: ");
		String key = "80";
		Value v1 = b.getPair(key, val); 
		if(val2 == null || val2.length == 0){
			System.out.println("no pair found");
			System.exit(0);
		}
		System.out.println(v1.getKey() + "\t" + v1.getValue());
	}
}
