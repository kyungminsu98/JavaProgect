package com.yedam.java.ch0603;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		System.out.println(myCar.compary);
		
		Car yourCar = new Car("기아자동차");
		System.out.println(yourCar.compary);
	}
}
