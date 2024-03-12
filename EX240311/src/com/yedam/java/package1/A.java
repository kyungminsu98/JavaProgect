package com.yedam.java.package1;

//class A { // default 접근 제한
public class A{
	B b;
		
	//필드
	public int field1;
	int field2;
	private int field3;
	
	//생성자
	public A() { // 같은 패키지며 같은 클래스
		this.field1 = 100;
		this.field2 = 200;
		this.field3 = 300;
		
		this.method1();
		this.method2();
		this.method3();
	}
	
	public A(boolean t) {}
	A(int b) {}
	private A(String s) {}
	
	A a1 = new A(true);
	A a2 = new A(100);
	A a3 = new A("문자열");
	
	//메소드
	public void method1() {}
	void method2() {}
	private void method3() {}
}
