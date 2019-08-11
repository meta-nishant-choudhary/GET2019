package quest2.com.meta;

public class Employee {
	
	private int id;
	private double salary;
	private int age;
	
	public Employee(int id, double salary, int age) {
		try {
			this.id = id;
			this.salary = salary;
			this.age = age;
		}
		catch (Exception e) {
			throw new AssertionError("wrong input ");
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public int getAge() {
		return this.age;
	}
	
	
	/**
	 * to sort the program using insertion sort
	 * @param employee type: Employee object array
	 * @return employee : sorted array of object type Employee
	 */
	public static Employee[] insertionSort(Employee[] employee) {
		if(employee == null) {
			throw new AssertionError("null employee");
		}
		
		if(employee.length == 0) {
			throw new AssertionError("empty employee");
		}
		
		int j;
		
		for (int i = 1; i < employee.length; i++) {
			Employee temp = employee[i];
			j = i;
			while (j > 0 && employee[j - 1].getSalary() > temp.getSalary()) {
				employee[j] = employee[j - 1];
				--j;
			}
			employee[j] = temp;
		}
		for(int i = 0; i < employee.length; i++) {
			for(j = i + 1; j < employee.length; j++) {
				if(employee[i].getSalary() == employee[j].getSalary()) {
					if(employee[i].getAge() > employee[j].getAge()) {
						Employee t = employee[i];
						employee[i] = employee[j];
						employee[j] = t;
					}
				}
			}
		}
		return employee;
	}
}
