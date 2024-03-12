package com.yedam.java.package3;

public class Car {
	//필드
	private int speed;
	private boolean stop;
	
	//생성자
	
	//메소드 - getter/setter
	public int getSpeed() { 
	// getter
	// public 필드데이터타입 get필드이름() 
	// { return this.필드이름; }
		return this.speed;
	}
	
	public void setSpeed(int speed) { 
	// setter
	// public void set필드이름(필드데이터타입 매개변수명)
	// { this.필드이름 = 매개변수명; }
		if(speed > 0) {
			this.speed = speed;
		}else {
			this.speed = 0;
		}
	}
	
	public boolean isStop() {
		return this.stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		//this.speed = 0;
		this.setSpeed(0);
	}
}
