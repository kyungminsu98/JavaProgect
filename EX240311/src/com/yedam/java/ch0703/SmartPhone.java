package com.yedam.java.ch0703;

public class SmartPhone extends Phone{
	public SmartPhone(String owner) {
		super(owner);
	}
	@Override
	public void execute() {
		System.out.println("어플을 실행합니다");
	}
}
