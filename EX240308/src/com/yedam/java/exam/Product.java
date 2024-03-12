package com.yedam.java.exam;

public class Product {// 상품정보 - 상품명, 가격
	//필드 - 정보
	//상품명 => 문장 => String
	//String name;
	private String name;
	//가격  => 우리나라 기준 통화단위(원), 소수점이하X => 정수, int
	//int price;
	private int price;
	
	//생성자 - 초기화(필드들)
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	//메소드 - 기능 => X
	// 각 필드에 private 추가 => getter/setter
	// 필드 : name => String
	public String getName(){ 
		return this.name; 
	}
	
	public void setName(String name){ 
		this.name = name; 
	}	
	
	// 필드 : price
	// getter -> return(클래수 내부 필드값을 외부에 전달)
	public int getPrice() {
		return this.price;
	}	
	
	// setter -> 매개변수(외부에서 전달받은 값을 클래스 내부 필드값에 할당)
	public void setPrice(int price) {
		this.price = price;
	}
}
