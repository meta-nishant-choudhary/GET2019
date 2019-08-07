package quest2.com.metacube;

public class Employee implements Cloneable {
	
	
	public Object clone()throws CloneNotSupportedException{  
		
		Node head2 = null;
		Node temp = this.head;
		Node newNode;
		while(temp != null) {
			newNode = new Node(temp.getId(), temp.getSalary(), temp.getAge());
			if(head2 == null) {
				head2 = newNode;
			}
			else {
				Node temp2 = head2;
				while(temp2.next != null) 
					temp2 = temp2.next;
				temp2.next = newNode;
			}
			newNode.next = null;

			temp = temp.next;
		}
		return head2;  
	}
	
	public Node sorted = null;
	public Node current = null;
	public Node head = null;
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee emp = new Employee();
		emp.addEmployee(1,101,21);
		emp.addEmployee(2,301,24);
		emp.addEmployee(3,301,22);
		
		Employee ep2 = new Employee();
		ep2.head =(Node) emp.clone();
		
		Node ptr = ep2.insertionSort(ep2.head);
		System.out.println("");
	}
	
	/**
	 * add employee in linked list
	 * @param id type: int
	 * @param salary type: int
	 * @param age type: int
	 * @return head pointer of the list type: node
	 */
	public boolean addEmployee(int id, int salary, int age) {
		Node new_Node = new Node(id, salary, age);	
		if(head == null) {
			head = new_Node;
			return true;
		}
		
		Node last = head; 
		while(last.next != null){
			last = last.next;
		}
		last.next = new_Node;
		return true;
	}
	
	/**
	 * to pick the node and send to insert and sort
	 * @param headref type: Node
	 * @return head of the list
	 */
	Node insertionSort(Node headref)  
	{ 
	    // Initialize sorted linked list 
		sorted = null; 
		current = headref; 
		
		while (current != null)  
		{ 
			Node next = current.next;  
			sortedInsert(current);  
		    current = next; 
		}  
		head = sorted; 
	
		return head;
	} 
		  
	 /** 
	 * function to insert a new_node in a list.
	 * @param newnode : new node which add in list according to its sort
`	 **/
	void sortedInsert(Node newnode) {

		if (sorted == null || sorted.getSalary() <= newnode.getSalary())  
		{ 
		    newnode.next = sorted; 
		    sorted = newnode; 
		} 
		else { 
			current = sorted; 
	        if(current.next.getSalary() > newnode.getSalary()) {
				while (current.next != null && current.next.getSalary() > newnode.getSalary())
		        {
		        	
		            current = current.next; 
		        }
	        }
	        else if((current.next.getSalary() == newnode.getSalary()) && (current.next.getAge() > current.next.getAge())) {
	        	while (current.next != null && (current.next.getSalary() == newnode.getSalary()) && (current.next.getAge() > current.next.getAge())){
	        		current = current.next;
	        	}
	        }
	        
	        newnode.next = current.next; 
	        current.next = newnode; 
	    } 
	} 
	 
}
