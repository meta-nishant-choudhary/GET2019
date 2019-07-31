package DSA.metacube.com;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.ExceptionList;

public class LinkedList {
	private static ArrayList<Node> polyList = new ArrayList();
	private static Node head = null;
	
	/*
	 * append methos is used to append elements in the linked list
	 * @param arr type: array of integers
	 * return head type: Node
	 */
	public static Node append(int[] arr) { 
		if(arr == null){
			throw new AssertionError();
		}
		for(int i = 0;i < arr.length; i++) {
			Node new_node = new Node(arr[i]); 
			if (head == null) 
		    { 
		        head = new_node;
		    } 
			else {
			    new_node.next = null; 
			    Node last = head;  
			    while (last.next != null) {
			        last = last.next; 
			    }
			    last.next = new_node;
			}
		}
	    return head; 
	}
	
	/**
	 * rotate list used to rotate list in between the range
	 * @param L type: int
	 * @param R	type: int
	 * @param N type: int
	 * @return head type: Node
	 */
	public static Node rotateList(int L,int R, int N) {
		if(L >= R-1 || N == 0) {
			throw new AssertionError();
		}
		
		Node ptr = head;
		Node leftPtr = null;
		Node rightPtr = null;
		Node ptr1 = null;
		Node ptr2 = null;
		
		for(int i = 0; i < N; i++) {
			ptr = head;
			for( int j = 1; j < L; j++) {
				leftPtr = ptr;
				ptr = ptr.next;
			}
			ptr = head;
			
			for( int j = 1; j < R; j++) {			
				rightPtr = ptr;
				ptr = ptr.next;
			}
			
			ptr1  = leftPtr.next;
			ptr2 = rightPtr.next.next;
			leftPtr.next = rightPtr.next;
			leftPtr.next.next = ptr1;
			rightPtr.next = ptr2;
		}
		ptr2 = null;
		return head;
	}
	
	/**
	 * detectLoop is used to detect the loop in linked list
	 * @return true: if loop detect else: false
	 */
	public static boolean detectLoop() {
		ArrayList<Node> s = new ArrayList<Node>();
		Node ptr = head;
		while(ptr != null) {
			if (s.contains(ptr)) {
				return true;
			}
			s.add(ptr);
			ptr = ptr.next;
		}
		return false;
	}
}
