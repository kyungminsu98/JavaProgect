package com.yedam.java.homework;

public class Human {
	//필드
	protected String name;
	protected int height;
	protected int weight;
	
	//생성자
	public Human(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;		
	}
	
	//메소드
	public void getInformation() {
		System.out.print("이름 : " + this.name + " 키 : " + this.height + " 몸무게 : " + this.weight);
	}

}
