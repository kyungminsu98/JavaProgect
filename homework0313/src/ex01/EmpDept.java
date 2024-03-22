package com.yedam.java.homework;

public class EmpDept extends Employee {
	//필드
	private String department;
	//생성자
	public EmpDept(String name, String department, int salary) {
		super(name, salary);
		this.department = department;
	}
	//메소드
	@Override
	public void getInformation() {
		System.out.println("이름 : " + this.name + " 연봉 : " + this.salary + " 부서 : " + this.department);
	}
	@Override
	public void print() {
		super.print();
		System.out.println("서브클래스");
	}
}	

