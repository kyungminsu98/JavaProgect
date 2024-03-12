package com.yedam.java.package3;

public class SingletonExample {

	public static void main(String[] args) {
		//Singleton one = new Singleton();
		Singleton one = Singleton.getInstance();
		
		Singleton two = Singleton.getInstance();
		
		if(one == two) {
			System.out.println("동일한 객체를 참조합니다.");
		}else {
			System.out.println("서로 다른 객체를 참조합니다.");
		}
	}

}
