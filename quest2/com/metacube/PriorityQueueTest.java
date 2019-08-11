package quest2.com.metacube;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * test class for the priority queue
 */
public class PriorityQueueTest {

	@Test
	public void test() {
		PriorityQueueImpl queue = new PriorityQueueImpl();
		queue.enqueue(31,3);
		queue.enqueue(4, 2);
		queue.enqueue(66, 5);
		assertEquals(4,queue.dequeue());
		queue.enqueue(65, 7);
		queue.enqueue(12, 0);
		assertEquals(12,queue.dequeue());
	}
}