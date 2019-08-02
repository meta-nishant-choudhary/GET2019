package Ques2.com.metacube;

interface Queue {
	
	public Integer[] enqueue(int item);
	public Integer[] dequeue();
	public boolean isEmpty();
	public boolean isFull();
}
