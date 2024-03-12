package com.yedam.java.ch0605;

public class FinalExample {
	public static void main(String[] args) {
		// 정적 필드 상수
		System.out.printf("지구 반지름 : %.2f, 지구 표면적 : %.10f\n", 
							Earth.EARTH_RADIUS, Earth.EARCH_AREA);
		
		// 인스턴스 필드 상수
		Person kang = new Person("1234", "Kang");
		System.out.printf("%s, %s, %s\n", 
					kang.nation, kang.ssn, kang.name);
		//kang.ssn = "0987";
		
		Person lee = new Person("6789", "Lee");
		System.out.printf("%s, %s, %s\n", 
					lee.nation, lee.ssn, lee.name);
	}
}
