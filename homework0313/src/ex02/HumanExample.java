package com.yedam.java.homework;

public class HumanExample {

	public static void main(String[] args) {
		Human human = null;
		
		human = new StandardWeightInfo("홍길동", 168, 45);
		human.getInformation();
		
		human = new ObesityInfo("박돌이", 168, 90);
		human.getInformation();
	}

}
