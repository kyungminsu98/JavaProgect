package homework;

public class EmpDept extends Employee{
	protected String department;
	
    public EmpDept(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }
	
	public String getDepartment() {
		return department;
	}
	@Override
	public void getinformation() {
		System.out.println("이름 : " + this.name + " 연봉 : " + this.salary + " 부서 : " + this.department);
	}
    public void print() {
        super.print();
        System.out.println("슈퍼클래스\n서브클래스");
    }
}