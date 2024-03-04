package com.yedam.java.ch02;

public class VariableExmpla {

	public static void main(String[] args) {
		// 정수
		byte var1 = 127;
		short var2 = -32768;
		int var3 = 0xA;
		long var4 = 9000000000L;
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		
		
		
		// char
		char c1 = 'A';
		char c2 = (char)(c1*2);
		char c3 = 67;
		System.out.println((int)c1);
		System.out.println((int)c2);
		System.out.println(c3);
		
		// 문자열 (문장) =>String
		String c4 = "\"AB\"를 문자열로 인식합니다.";
		String c5 = c4+1;
		
		System.out.println(c4);
		System.out.println(c5);
		
		// 실수 
		float f1 = 0.12345678912345F;
		double d1 = 0.12345678912345;
		System.out.println(f1);
		System.out.println(d1);
		
		// 논리
		boolean isSelected = true;
		
		if(isSelected) {
			System.out.println("선택한 값은 ...");
		}else {
			System.out.println("선택한 값이 존재하지 않습니다.");
		}
	}

}
