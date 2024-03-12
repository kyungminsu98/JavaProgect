package com.yedam.java.package2;

import com.yedam.java.package1.A;
import com.yedam.java.package1.B;

public class C {
	A a = new A();
	B b;
	
	public C() { //다른 패키지이며 다른 클래스
		a.field1 = 100;
		a.field2 = 200;
		a.field3 = 300;
		
		a.method1();
		a.method2();
		a.method3();
		
		A a1 = new A(true);
		A a2 = new A(100);
		A a3 = new A("문자열");
	}
	
	
}
