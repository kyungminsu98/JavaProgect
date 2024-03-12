package com.yedam.java.ch0702;

public class ParentChildExample {

	public static void main(String[] args) {
		// 자동타입변환 : 자식 -> 부모, 자식 고유의 필드와 메소드는 사용불가
		// 변수의 데이터 타입이 부모 클래스를 의미
		// -> 데이터 타입을 기준으로 사용가능한지 아닌지를 판단
		// 예외적인 상항) 메소드 오버라이딩 -> 자식 클래스의 메소드를 사용
        Parent parent = null;
        parent.method1(); // 부모 클래스의 정적 메소드 호출
        parent.method2(); // 부모 클래스의 인스턴스 메소드 호출
//		parent.method3();
		
		// ** 강제타입변환 : 부모 -> 자식, 에러가 날 확률이 높음
		// 전제조건 : 자동타입변환이 선행된 대상만 가능
		// 항상 instanceof 사용을 권장함.
		if(parent instanceof Child) { 
			// 변수 parent가 가진 인스턴스가 Child 클래스의 인스턴스가 맞는지
			Child child = (Child)parent;
			child.method1();
			child.method2();
			child.method3();
		}
		if(parent instanceof Second) {
			// 변수 parent가 가진 인스턴스가 Second 클래스의 인스턴스가 맞는지
			Second second = (Second)parent;
			second.method1();
			second.method2();
			second.method4();
		}
	}

}
