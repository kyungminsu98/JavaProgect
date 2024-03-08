package com.yedam.java.ch0603;

public class VendingMachine {
	// 필드
	String[] list ;
	// 생성자
	VendingMachine(){
		list = new String[] {"콜라","생수","오렌지주스","탄산수"};
	}
	// 메소드
	
	// 리턴타입 메소드이름([매개변수,]){실행코드}
	String getBeverage(int menu) {
		String selectedProduct = list[menu-1];
		return selectedProduct;
//		System.out.println("메소드가 종료되었습니다");
	}
}

