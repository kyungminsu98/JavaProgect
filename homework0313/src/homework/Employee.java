package homework;

public class Employee{
	protected String name;
	protected int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	
	public void getinformation() {
		System.out.println("이름 : " + this.name + " 연봉 : " + this.salary);
	}
	public void print() {
		System.out.println("수퍼클래스");
	}

}
