package quest1.com.meta;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

/*
 * DictionaryImpl class implementation of Dictionary interface
 * provides function for dictionary operation
 */
public class DictionaryImpl implements Dictionary{

	Node head;
	
	/*
	 * parameterized constructor
	 * @input json object
   	 */
	public DictionaryImpl(JSONObject jsonObject) throws Exception {
		this.head = null;
		this.input(jsonObject);
	}
	
	//default constructor
	public DictionaryImpl() {
	}

	/*
	 * method for add key and value from json object
	 * @param jsonObject
	 */
	private boolean input(JSONObject jsonObject) throws Exception {
		
		for(Object obj : jsonObject.keySet()){
			String key = (String)obj;
			String value = (String) jsonObject.get(key);
			this.add(key, value);
		}
		return true;
	}


	/**
	 * method for add key and value in BST
	 *  
	 */
	@Override
	public boolean add(String key, String value) {
		if(key == null || value == null){
			throw new AssertionError("null key and value");
		}
		
		if(key.length() == 0 || value.length() == 0 ){
			throw new AssertionError("Empty key and value");
		}
		if(head == null){
			head = new Node(key,value);
		}else{
			addRec(key,value,head);
		}
		return false;
	}
	
	/**
	 * Recursive function for adding key and value in BST 
	 * @param key
	 * @param value
	 * @param node
	 * @return
	 */
	private boolean addRec(String key,String value,Node node){
		//go left if key less than current node key
		if (key.compareTo(node.getKey()) <= -1){
			if(node.getLeft() != null){
				//if left is present call recursive
				addRec(key, value, node.getLeft());
			}
			else{
				//add value to left 
				node.setLeft(new Node(key,value));
				node.getLeft().setParent(node);
			}
		}
		//go right if key is greater than current node key
		else if(key.compareTo(node.getKey()) >= 1){
			if(node.getRight() != null){
				//if right is present call recursive
	            addRec(key, value, node.getRight());
			}
			else{
				//add value to right
				node.setRight(new Node(key,value));
				node.getRight().setParent(node);
			}
		}
		else{
			node = new Node(key,value);
		}
		return true;
	}
	
	/**
	 * method for delete a key and value form BST
	 * @param key
	 */
	@Override
	public boolean delete(String key) throws Exception {
		if(key == null ){
			throw new AssertionError("null key");
		}
		
		if(key.length() == 0 ){
			throw new AssertionError("Empty key");
		}
		
		if(head != null){
			return deleteRec(key,head);
		}
		return false;
	}
	
	/**
	 * recursive function for deleting a key form BST
	 * @param key
	 * @param node
	 * @return
	 */
	private boolean deleteRec(String key,Node node){
		//go left if key less than current node key
		if(key.compareTo(node.getKey()) <= -1){
			if(node.getLeft() != null){
				//if left is present call recursive
				return deleteRec(key, node.getLeft());
			}
		}
		//go right if key is greater than current node key
		else if(key.compareTo(node.getKey()) >= 1){
			if(node.getRight() != null){
				//if right is present call recursive
				return deleteRec(key, node.getRight());
			}
		}
		//if key is equal to node key
		else if(key.compareTo(node.getKey())==0){
			//check if it is a leaf node
			if(node.getLeft() == null){
				if(node.getRight() == null){
					//set parent child null if it is leaf node
					if(node.getParent().getLeft() == node){
						node.getParent().setLeft(null);
					}
					else{
						node.getParent().setRight(null);
					}
				}
			}
			//if left node is null
			else if(node.getLeft() == null && node.getRight() != null){
				//if self is left than set parent left else set parent right
				if(node.getParent().getLeft() == node){
					node.getParent().setLeft(node.getRight());
				}
				else{
					node.getParent().setRight(node.getRight());
				}
			}
			//if right is null
			else if(node.getRight() == null && node.getLeft() != null){
				//if self is right set parent right else set parent left
				if(node.getParent().getRight() == node){
					node.getParent().setRight(node.getLeft());
				}
				else{
					node.getParent().setLeft(node.getLeft());
				}
			}
			
			else{
				Node newNode = findMin(node.getRight());
				node.setKey(newNode.getKey());
				node.setValue(newNode.getValue());
				return deleteRec(newNode.getKey(), newNode);
			}
		}
			
		return true;
		
	}

	/**
	 * method to find minimum value from tree
	 * @param currentNode
	 * @return
	 */
	private Node findMin(Node currentNode){
		while(currentNode.getLeft() != null){
			currentNode = currentNode.getLeft();
		}
		return currentNode;
		
	}
	
	/**
	 * method to traverse tree
	 * @param root
	 * @param list
	 * @return
	 */
	private List<Value> inorderRec(Node root,List<Value> list) { 
		if (root != null) { 
			inorderRec(root.left,list);
	        list.add(new Value(root.getKey(),root.getValue()));
	        inorderRec(root.right,list); 
	    }
	    return list;
	} 
	
	/**
	 * method to find a value with key
	 * @param key
	 */
	@Override
	public String getValue(String key) {
		if(head != null){
			return getValueRec(key,head);
		}
		return null;
	}
	
	/**
	 * recursive method to find a value form tree
	 * @param key
	 * @param node
	 * @return
	 */
	private String getValueRec(String key,Node node){
		if(node == null){
			return null;
		}
		else if(key.compareTo(node.getKey()) == 0){
			return node.getValue();
		}
		else if(key.compareTo(node.getKey()) <= -1){
			return getValueRec(key, node.getLeft());
		}
		else if(key.compareTo(node.getKey()) >= 1){
			return getValueRec(key, node.getRight());
		}
		else
			return null;
	}

	/*
	 * method to find all values from tree
	 */
	@Override
	public List<Value> getAll() {
		List<Value> valueList = new ArrayList<Value>();
		if(head != null){
			valueList = inorderRec(head,valueList);
		}
		return valueList;
	}

	/**
	 * method to find value of key between keys
	 * @param key1
	 * @param key2
	 */
	@Override
	public List<Value> getBetween(String key1 ,String key2) {
		List<Value> list = getAll();
		List<Value> finalList = new ArrayList<Value>();
		for(Value v : list){
			if(v.getKey().compareTo(key1) >= 1 && v.getKey().compareTo(key2) <= -1){
				finalList.add(v);
			}
		}
		return finalList;
	}
	
	
}