package com.yedam.java.homework;

public class EmployeeExample {

	public static void main(String[] args) {
		Employee empInfo = new EmpDept("이지나", "교육부", 3000);
		empInfo.getInformation();
		empInfo.print();
	}

}
