package com.yedam.java.ch0603;

public class Car {
	// 필드
	String compary;
	String model;
	String color;
	int maxSpeed;
	int speed;
	
	// 생성자
	Car(){
//		this.compary = "현대자동차";
//		this.model = "그랜저";
//		this.color = "검정";
//		this.maxSpeed = 300;
		this("현대자동차","그랜저","검정"); // 문장의 맨위에 있어야함.00
	}
	Car(String company){
		this(company, "그랜저", "검정");
	}
	Car(String company, String model){
//		this.compary = "company";
//		this.model = "model";
//		this.color = "검정";
//		this.maxSpeed = 300;
		this(company, model, "검정");
	}
	Car(String company, String model, String color){
		this.compary = "company";
		this.model = "model";
		this.color = "color";
		this.maxSpeed = 300;
	}
//	System.out.println(color);
}
