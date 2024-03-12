package com.yedam.java.ch0702;

public class NexenTire {
	// 필드
	public int maxRotation;
	public String location;
	public int accumulatedRotation;
	// 생성자
	NexenTire(String location, int maxRotation){
		super(location, maxRotation); // 부모 생성자 호출
	}
	@Override
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation < maxRotation) {
			System.out.printf("%s 넥센 Tire 수명 : %d회 \n",location,(maxRotation - accumulatedRotation));
			
		}else {
			System.out.printf("**** %s 넥센 Tire 펑크 **** \n",location);
			return false;
		}
		return false;
	}

}
