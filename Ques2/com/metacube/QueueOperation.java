package Ques2.com.metacube;

import java.util.ArrayList;

public class QueueOperation implements Queue {

	public int front = 0;
	public int rear = 0;
	public int capacity;
	public int[] queue;

	public QueueOperation(int capacity) {
		super();
		this.capacity = capacity;
		this.queue = new int[capacity];
	}

	@Override
	public boolean addElementInQueue(int element) {
		if (this.capacity == this.rear) {
			return false;
		}
		this.queue[rear] = element;
		this.rear++;
		return true;
	}

	@Override
	public int[] deleteElementInQueue(int[] queue) {
		if (queue.length == 0) {
			throw new AssertionError("Empty Array");
		}

		if (queue == null) {
			throw new AssertionError("Null Array");
		}

		for (int i = 0; i < queue.length; i++) {
			queue[i] = queue[i + 1];
		}
		return queue;
	}

	@Override
	public boolean isQueueEmpty() {
		if (this.front != this.rear) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isQueueFull() {
		if (this.front == this.rear) {
			return true;
		}
		return false;
	}
	
	
}
