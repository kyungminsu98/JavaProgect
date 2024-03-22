package com.yedam.java.homework;

public class Employee {
	//필드
	protected String name;
	protected int salary;
	//생성자
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	//메소드
	public void getInformation() {
		System.out.println("이름 : " + this.name + " 연봉 : " + this.salary);
	}
	
	public void print() {
		System.out.println("수퍼클래스");
	}

}
