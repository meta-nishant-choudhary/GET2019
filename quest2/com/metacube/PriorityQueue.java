    
package quest2.com.metacube;

/**
 * interface for priority queue 
 *
 */
public interface PriorityQueue {
	
	public void enqueue(int data, int priority);
	
	public int dequeue();
	
	public int peek();

}