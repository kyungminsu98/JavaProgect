package com.yedam.java.extend;

public class MethodOverrideExample {

	public static void main(String[] args) {
		Computer com = new Computer();
		double result = com.areaCircle(10);
		System.out.println("Computer :" + result);
		
		com.print();
		result = com.selectedParentMethod(5);
		System.out.println("");
	}

}
