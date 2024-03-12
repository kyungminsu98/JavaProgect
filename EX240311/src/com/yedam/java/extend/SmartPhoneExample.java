package com.yedam.java.extend;

public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("갤럭시S24", "화이트", true);
		
		// 부모 클래스 멤버 접근
		System.out.println("현재 모델 > " + sp.model);
		sp.powerOn();
		sp.bell();
		
		// 자식 클래스 멤버 접근
		sp.exeucteApp("카카오톡");
		System.out.println("어플 > " + sp.application);
		sp.connectOff();
				
	}

}
