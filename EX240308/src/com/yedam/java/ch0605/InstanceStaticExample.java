package com.yedam.java.ch0605;

public class InstanceStaticExample {

	public static void main(String[] args) {
		// 필드
		String msg = "Hello, JAVA!!!"; // 인스턴스 필드 
		static String week = "Today is Friday"; // 정적필드
		// 메소드
		void printMsg() {// 인스턴스메소
			System.out.println("msg :"+ this.msg);
			System.out.println("week :"+ InstanceStaticExample.week);
		}
		public static void main(String[] args) {
			// 정적 메소드 : this X
			// System.out.println("msg :"+ this.msg);
			InstanceStaticExample ise = new InstanceStaticExample();
			System.out.println("msg :"+ ise.msg);
			System.out.println("week :"+ InstanceStaticExample.week);
		}
		// 인스턴스 멤버
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		
		myCar.run();
		System.out.println();
		yourCar.run();
		
		System.out.println("==================");
		// 정적멤버
		double result1 = 10*10* Calculator.pi;
		int result2 = Calculator.plus(10,5);
		int result3 = Calculator.minus(10, 5);
		System.out.printf("%f, %d, %d\n",result1,result2,result3);
	}

}
