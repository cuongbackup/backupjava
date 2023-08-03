package fileWorking;

public class Employee {
	private String name;
	private int age;
	private String address;
	private int salary;
	private int coefSalary = 1050000;
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, String address, int salary, int coefSalary) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
		this.coefSalary = coefSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double calSalary() {
		return salary * 2.34;
	}
	public void display() {
		System.out.printf("%-15s %-15d %-15s %-15.2f\n", getName(), getAge(), getAddress(), calSalary());
	}
}
