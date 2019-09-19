package DSA.Assignment3.priotityqueue;

import java.util.Arrays;

public class PriorityQueue {
	private Integer size = 0, index = -1;
	private PriorityQueueNode[] queue = new PriorityQueueNode[10];
	/**
	 * enqueue to add element
	 * @param item
	 * @param priority
	 */
	public void enqueue(Integer item, Integer priority) {
		PriorityQueueNode p = new PriorityQueueNode(item, priority);
		index++;
		
		Integer temp = 0;
		if(queue[index] == null) {
			for(int i = 0; i < size; i++) {
				if(queue[i].getPriority() > priority) {
					int j = size;
					while(j == index) {
						queue[j] = queue[j-1];
						j--;
					}
					queue[i] = p;
					size++;
					return;
				}		
			}
			queue[index] = p;
			size++;
		}
	}
	
	/**
	 * tp delete element
	 */
	public Integer dequeue() {
		Integer i = queue[index].getItem();
		index--;
		size--;
		return i;
	}
	
	public Integer peek() {
		return queue[0].getItem();
	}
	
	public static void main(String[] args) {
		PriorityQueue p = new PriorityQueue();
		Arrays.fill(p.queue, null);
		p.enqueue(1, 1);
		p.enqueue(2, 2);
		p.enqueue(4, 4);
		p.enqueue(3, 3);
		p.enqueue(5, 5);
		for(int i = 0; i < p.size(); i++) {
			System.out.println("priority: " + p.queue[i].getPriority() + "\t item: " + p.queue[i].getItem());
		}
		System.out.println("");
		p.dequeue();
		for(int i = 0; i < p.size(); i++) {
			System.out.println("priority: " + p.queue[i].getPriority() + "\t item: " + p.queue[i].getItem());
		}
		
		System.out.println("\npeek: " + p.peek());
	}
}
