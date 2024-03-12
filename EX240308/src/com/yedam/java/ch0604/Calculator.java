package com.yedam.java.ch0604;

public class Calculator {
	//필드
	
	//생성자
	
	//메소드 : 리턴타입 메소드이름([매개변수,]) { 실행코드 }
	// 1.입력값 => 매개변수          예시 : 1,5   =>  6
	// 2.출력값 => 리턴문 -> 리턴타입
	//더하기 => 숫자1 + 숫자2
	int plus(int x, int y) {
		int reuslt = x + y;
		return reuslt;
	}

	int plus(double x, double y) {
		int result  = (int)(x + y);
		return result;
	}
	
	int plusDouble(double x, double y) {
		int result  = (int)(x + y);
		return result;
	}
	
	//빼기 : 정수 2개 받아서 하나의 정수값 예시 : 1, 5 => -4
	int minus(int x, int y) {
		int result = x - y;
		return result;
	}
	
	//평균 = 합계 / 갯수
	double avg(double x, double y) {
		double result = this.plus(x,y)/2.0;
		return result;
	}
}
