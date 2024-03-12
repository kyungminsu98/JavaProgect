package com.yedam.java.ch0702;

public class Car {
	// 필드의 다형성
	// 필드 : 자동타입변환으로 값 초기화
	Tire frontLeftTire = new Tire("앞왼쪽",6); // 앞쪽중 왼쪽 타이어
	Tire frontRightTire = new KumhoTire("앞오른쪽",2); // 앞쪽중 오른쪽 타이어
	Tire backLeftTire = new Tire("뒤왼쪽",4); // 뒤쪽 중 왼쪽 타이어
//	Tire backRightTire = new HankookTire("뒤오른쪽",3); // 뒤쪽 중 오른쪽 타이어
	NexenTire backRightTire = new NexenTire("뒤오른쪽",5);
	// 메소드
	boolean run() {
		System.out.println("==자동차 달립니다.==");
		boolean isRun = true;
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
		return isRun;
	}
	void changerTire(int location, Tire newTire) {
		System.out.println("타이어를 교체합니다.");
		switch(location) {
		case 1 :
			frontLeftTire = newTire;
			break;
		case 2 :
			frontRightTire = newTire;
			break;
		case 3 :
			backLeftTire = newTire;
			break;
		case 4 :
			backRightTire = newTire;
			break;
		}
	}
}
