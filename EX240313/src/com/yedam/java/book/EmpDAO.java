package com.yedam.java.book;

import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	// 필드 = > 실제 자료를 저장하는 변소
	private List<Employee> employeeList;
	// 생성자
	public EmpDAO() {
		this.employeeList = new ArrayList<>();
	}
	// 메소드
	// 1) 추가
	public void addEmplnfo(int id, String name, String phone, String hireDate, int salary) {
		Employee emp = new Employee(id, name,  phone, hireDate, salary);
		employeeList.add(emp);
	}
	public void addEmplnfo(Employee emp) {
		employeeList.add(emp);
	}
	// 2) 수정
	public void updateEmpSalary(int id, int salary) {
	    for (int i = 0; i < employeeList.size(); i++) {
	        Employee emp = employeeList.get(i);
	        if (id == emp.getId()) {
	            emp.setSalary(salary);
	        }
	    }
	}
	// 3) 삭제
	public void delEmplnfo(int id) {
		for(int i=0; i<=employeeList.size()-1; i++) {
			Employee emp = employeeList.get(i);
			if(id == emp.getId()) {
				employeeList.remove(i);
			}
		}
	}
//	// 4) 조회
	public void searchHireDate(String hireDate) {
		Employee selected = null;
		for(Employee emp : employeeList) {
			if(hireDate.equals(emp.getHireDate())) {
				System.out.println(emp.getId() + " " +emp.getName() + " " + emp.getHireDate());
			}
		}
	}
	// 5) 출력
	public void printEmpAll() {
		for(Employee emp : employeeList) {
			System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getPhone() + " " + emp.getHireDate() + " " + emp.getSalary());
		}
	}
	
}