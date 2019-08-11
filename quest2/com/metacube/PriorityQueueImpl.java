package quest2.com.metacube;

/*
 * priority queue class implementation
 */
public class PriorityQueueImpl implements PriorityQueue {

	static final int SIZE = 100;
	int[][] elements=new int[SIZE][SIZE];
	int[][] indexes= new int[SIZE][2];

	//constructor
	public PriorityQueueImpl() {
		for(int x = 0 ; x < SIZE ; x++) {
			indexes[x][0] =- 1;
			indexes[x][1] =- 1;
		}
	}

	/**
	 * method for enqueue a item in the queue
	 * @param data
	 * @param priority
	 */
	@Override
	public void enqueue(int item, int priority) {
		if( indexes[priority][0] ==- 1)  {
			indexes[priority][0] = indexes[priority][0] + 1;
			indexes[priority][1] = indexes[priority][1] + 1;
			elements[priority][indexes[priority][1]] = item;

		}
		else {
			indexes[priority][1] = indexes[priority][1] + 1;
			elements[priority][indexes[priority][1]] = item;
		}
	}

	/**
	 * method for dequeue the item from the queue
	 */
	@Override
	public int dequeue() {
		int data;
		for(int x=0 ; x < SIZE ; x++) {
			if(indexes[x][0] >= 0) {
				data=elements[x][indexes[x][0]];
				indexes[x][0] = indexes[x][0] + 1;
				if(indexes[x][0] > indexes[x][1])   {
					indexes[x][0] = -1;
				}
				return data;
			}       
		} 
		return 0;
	}

	/**
	 * method to get top element from the queue
	 */
	@Override
	public int peek() {

		for(int x=0 ; x < SIZE ; x++) {
			if(indexes[x][0] >= 0) {
				int data = elements[x][indexes[x][0]];          
				return data;
			}       
		} 
		return 0;  
	}
	
}