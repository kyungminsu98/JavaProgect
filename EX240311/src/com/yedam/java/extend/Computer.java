package com.yedam.java.extend;

public class Computer extends Calculator{
	@Override // 메소드 오버라이딩 대상입니다.
    double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		 return Math.PI * r * r;
		
	}
    double selectedParentMethod(double r)  {
		//this.areaCircle(r);
		return super.areaCircle(r);
	}
}
