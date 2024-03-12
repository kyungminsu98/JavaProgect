package com.yedam.java.ch0702;

public class HankookTire extends Tire{
	// 필드
	
	// 생성자
	public HankookTire(String location, int maxRotation){
		super(location, maxRotation); // 부모 생성자 호출
	}
	// 메소드
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation < maxRotation) {
			System.out.printf("%s 한국 Tire 수명 : %d회 \n",location,(maxRotation - accumulatedRotation));
			
		}else {
			System.out.printf("**** %s 한국 Tire 펑크 **** \n",location);
			return false;
		}
		return false;
	}
}
