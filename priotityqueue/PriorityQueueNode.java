package DSA.Assignment3.priotityqueue;

public class PriorityQueueNode {
	Integer item;
	Integer priority;
	public PriorityQueueNode(Integer item, Integer priority) {
		super();
		try {
			this.item = item;
			this.priority = priority;
		}
		catch(Exception e) {
			System.out.println("Wrong type of input");
		}
	}
	
	//getter
	public Integer getItem() {
		return this.item;
	}
	
	public Integer getPriority() {
		return this.priority;
	}
}
