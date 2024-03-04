package com.yedam.java.ch02;

public class Promotion {

	public static void main(String[] args) {
		// 자동타입변환 -정수
		byte byteVal = 65;
		char charVal = (char)byteVal;
		int intVal = byteVal;
		System.out.println(intVal);
		
		
		
		// 자동타입변환 -실수
		float floatVal = 1.25F;
		double doubleVal = floatVal;
		System.out.println(doubleVal);
		
		doubleVal = intVal;
		System.out.println(doubleVal);
		
		intVal = (int)floatVal;
		System.out.println(intVal);
		
		// 연산에서의 타입변환
		byte a = 100;
		byte b = 10;
		int result = a + b; // 110
		long c = 10L;
		c = result + c;
		System.out.println(result);
		System.out.println(c);
		
		// int / int = 실수 버림 int / double = 실수나둠 
		int x = 10;
		int y = 4;
		double total = x / y;
		System.out.println(total);
		
		// 문자열 결합 연산
		String str = 10 + 2 + 8 + "";
		// String str = String.valueOf(10+2+8); 정석 위에는 꼼수
		System.out.println(str); // 20
		
		str = 10 + 2 + "8";
		System.out.println(str); //128
		
		str = 10 + "2" + 8;
		System.out.println(str); // 1028
		
		str = "10" + 2 + 8;
		System.out.println(str); // 1028
		
		str = "10" + (2 + 8);
		System.out.println(str); // 1010
		
	}

}
