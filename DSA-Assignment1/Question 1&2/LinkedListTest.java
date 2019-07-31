package DSA.metacube.com;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class LinkedListTest {
	
	/**
	 * check list append successfully
	 */
	@Test
	public void linkedListIsAppendTest() {
		int[] input = {2, 3, 4, 5, 6, 7};
		Node head = LinkedList.append(input);
		for(int i = 0; i < input.length; i++) {
			int data = head.data;
			//System.out.println("hello");
			assertEquals(data, input[i]);
			head = head.next;
		}
	}
	
	/**
	 * check if null array append to list
	 */
	@Test(expected = AssertionError.class)
	public void linkedListAppendNullTest() {
		int[] input = null;
		Node head = LinkedList.append(input);
	}
	
	/**
	 * check list is rotate or not
	 */
	@Test
	public void isListRotateTest() {
		int leftEnd = 2;
		int rightEnd = 5;
		int rotations = 2;
		int[] expected = {2, 5, 6, 3, 4, 7};
		Node head = LinkedList.rotateList(leftEnd, rightEnd, rotations);
		for(int i = 0; i < expected.length; i++) {
			int data = head.data;
			assertEquals(data, expected[i]);
			head = head.next;
		}
	}
	
	/**
	 * to check if input is not applicable to rotate the list
	 */
	@Test(expected = AssertionError.class)
	public void isListRotateWithWrongInput() {
		int leftEnd = 3;
		int rightEnd = 4;
		int rotations = 2;
		Node head = LinkedList.rotateList(leftEnd, rightEnd, rotations);
	}
	
	/**
	 * to check the method detect the loop or not
	 */
	@Test
	public void toDetectTheLoopMethodTest() {
		int[] input = {2, 3, 4, 5, 6, 7};
		Node head = LinkedList.append(input);
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = head.next;
		assertTrue(LinkedList.detectLoop());
	}
}
