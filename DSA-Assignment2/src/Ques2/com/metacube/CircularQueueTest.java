package Ques2.com.metacube;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CircularQueueTest {

	@Test
	public void enqueueTestForCorrectInput() {
		Integer maxSize = 3;
		CircularQueue QObj = new CircularQueue(maxSize);
		Integer input1 = 1;
		Integer input2 = 2;
		Integer input3 = 3;
		QObj.enqueue(input1);
		QObj.enqueue(input2);
		Integer[] expected = {input1, input2, input3};
		assertArrayEquals(expected , QObj.enqueue(input3));
	}
	
	@Test
	public void dequeueTest() {
		Integer maxSize = 3;
		CircularQueue QObj = new CircularQueue(maxSize);
		Integer input1 = 1;
		Integer input2 = 2;
		Integer input3 = 3;
		QObj.enqueue(input1);
		QObj.enqueue(input2);
		QObj.enqueue(input3);
		Integer[] expected = {null, input2, input3};
		assertArrayEquals(expected,  QObj.dequeue());
	}
	
	@Test
	public void isEmpty() {
		Integer maxSize = 1;
		CircularQueue QObj = new CircularQueue(maxSize);
		assertEquals(true, QObj.isEmpty());
	}
	
	@Test
	public void dequeueForEmptyTest() {
		Integer maxSize = 1;
		CircularQueue QObj = new CircularQueue(maxSize);
		String expected = "Circular Queue is empty. Element cannot be retrieved";
		try{
			QObj.dequeue();
		}catch(Exception ex){
			assertEquals(expected, ex.getMessage());			
		}
	}
	
	@Test
	public void enqueueForEmptyTest() {
		Integer maxSize = 2;
		CircularQueue QObj = new CircularQueue(maxSize);
		String expected = "Circular Queue is full. Element cannot be added";
		try{
			QObj.enqueue(1);
			QObj.enqueue(4);
			QObj.enqueue(3);
			QObj.enqueue(2);
		}catch(Throwable ex){
			assertEquals(expected, ex.getMessage());			
		}
	}
	
	@Test
	public void checkMaxSizeZeroTestError() {
		Integer maxSize = 0;
		String expected = "maxSize is zero";
		try {
			CircularQueue QObj = new CircularQueue(maxSize);	
		}
		catch(Throwable ex) {
			assertEquals(expected, ex.getMessage());			
		}
	}
	
	@Test
	public void checkMaxSizeNullTestError() {
		Integer maxSize = (Integer) null;
		String expected = "maxSize is null";
		try {
			CircularQueue QObj = new CircularQueue(maxSize);	
		}
		catch(Throwable ex) {
			assertEquals(expected, ex.getMessage());			
		}
	}
	
}
