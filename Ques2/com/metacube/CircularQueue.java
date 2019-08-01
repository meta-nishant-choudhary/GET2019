package Ques2.com.metacube;

import java.util.Arrays;

//public class CircularQueue {

   /* public static void main(String[] args) {

        CircularQueue<Integer> circularQueue = new CircularQueue(8);

        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);

        System.out.println("Full Circular Queue" + circularQueue);

        System.out.print("Dequeued following element from circular Queue ");
        System.out.println(circularQueue.dequeue() + " ");
        circularQueue.enqueue(23);
        System.out.println("After enqueueing circular queue with element having value 23");
        System.out.println(circularQueue);
    }
}*/

//implementation of Circular Queue using Generics
class CircularQueue implements Queue {

    private Integer currentSize; //Current Circular Queue Size
    private Integer[] circularQueueElements;
    private Integer maxSize; //Circular Queue maximum size

    private Integer rear;//rear position of Circular queue(new element enqueued at rear).
    private Integer front; //front position of Circular queue(element will be dequeued from front).      

    public CircularQueue(Integer maxSize) {
    	
    	if(maxSize == (Integer) null){
    		throw new AssertionError("maxSize is null");
    	}
    	
    	try {
    		this.maxSize = maxSize;
    	}
    	catch (Exception e) {
    		throw new AssertionError("Wrong input for maxSize");
    	}
    	
    	if(maxSize == 0) {
    		throw new AssertionError("maxSize is zero");
    	}
    	
    	
    	
    	this.circularQueueElements = new Integer[this.maxSize];
        this.currentSize = 0;
        this.front = -1;
        this.rear = -1;
    }

    /**
     * Enqueue elements to rear.
     */
    public Integer[] enqueue(int item) {
    	/*if(item == (Integer) null){
    		throw new AssertionError("item is null");
    	}*/
    	
        if (isFull()) {
            throw new AssertionError("Circular Queue is full. Element cannot be added");
        }
        else {
            this.rear = (this.rear + 1) % this.circularQueueElements.length;
            this.circularQueueElements[rear] = item;
            this.currentSize++;
            
            if (this.front == -1) {
				this.front = rear;
			}
        }
        return this.circularQueueElements;
    }

    /**
     * Dequeue element from Front.
     */
    public Integer[] dequeue() {
        if (isEmpty()) {
        	throw new NullPointerException("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            this.circularQueueElements[this.front] = (Integer) null;
            this.front = (this.front + 1) % this.circularQueueElements.length;
            this.currentSize--;
        }
        return circularQueueElements;
    }

    /**
     * Check if queue is full.
     */
    public boolean isFull() {
        if(this.currentSize == this.circularQueueElements.length) {
        	return true;
        }
        return false;
    }

    /**
     * Check if Queue is empty.
     */
    public boolean isEmpty() {
        if(this.currentSize == 0) {
        	return true;
        }
        return false;
    }
}