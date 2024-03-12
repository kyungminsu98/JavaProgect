package com.yedam.java.ch0702;

public class ParentChildExample {

	public static void main(String[] args) {
		// 자동타입변환 : 자식 -> 부모
		Parent parent = new Child();
		Parent.method1();
		Parent.method2();
		Parent.method3();
	}

}
