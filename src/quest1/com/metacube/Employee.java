package quest1.com.metacube;

public class Employee {
	private int empId;
	private String empName;
	private String empAddress;
	
	public Employee(int empId, String empName, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	
	public int getId() {
		return this.empId;
	}
	
	public String getName(){
		return this.empName;
	}
	
	public String getAddress(){
		return this.empAddress;
	}
}
