package com.yedam.java.ch0801;

public interface RemoteControl {
	// 상수 -> 모든 필드에는 static fianl이 생략되어있음.
	public int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	// 추상 메소드 -> 모든 메소드에는 abstract가 생략되어있음.
	public void turnOn();
	public abstract void turnOff();
//	default void printMessage(String message) {
//		System.out.println(message);
//	}
}
