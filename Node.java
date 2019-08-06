package quest2.com.metacube;

public class Node {
	private int id;
	private int age;
	private int salary;
	public Node next;
	
	public Node(int id, int salary, int age) {
		try {
			this.id = id;
			this.salary = salary;
			this.age = age;
			this.next = null;
		}
		catch (Exception e) {
			throw new AssertionError("Wrong type input");
		}
	}
	
	//getter
	public int getId() {
		return this.id;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public int getAge() {
		return this.age;
	}
	
	//setter
	public void setId(int id) {
		this.id = id;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
