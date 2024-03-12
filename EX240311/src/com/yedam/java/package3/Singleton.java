package com.yedam.java.package3;

public class Singleton {
	private static Singleton instance = null;
	
	private Singleton(){
		System.out.println("인스턴스를 생성했습니다.");
	}

	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton(); 
		}
		return instance;
	}
}
