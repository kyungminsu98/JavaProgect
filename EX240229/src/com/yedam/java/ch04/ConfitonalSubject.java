package com.yedam.java.ch04;

public class ConfitonalSubject {

	public static void main(String[] args) {
		// 문제1) 두 개의 정수가 주어졌을 때 두 정수의 합이 자연수이면 'Natural Number'을 출력하도록 하세요.
		int a = 2;
        int b = 3;
        
        int sum = a + b;
        
        if(sum > 0) {
            System.out.println("Natural Number");
        }

		// 문제2) 두 개의 정수가 주어졌을 때 두 수의 대소관계에 따라 부등호( > or = or < )를 출력하도록 하세요.
		int x = 5;
		int y = 3;
		if(x > y) {
			System.out.println(">");
		}else if(x == y) {
			System.out.println("=");
		}else {
			System.out.println("<");
		}
		/* 문제3) 체질량 지수인 BMI에 따라 비만도를 네가지 단계로 구분하여 결과값을 출력하도록 하세요.
		   BMI = 체중 / ( 키 * 키 )
		   저체중(18.5미만), 정상(18.5 이상 25미만), 과체중(25이상 30미만), 비만(30이상) */
		double weight = 80;
		double height = 180;
		double heightMeter = height / 100.0;
		double bmi = weight / (heightMeter*heightMeter); 
		if(bmi >= 30) {
			System.out.printf("비만입니다.");
		}else if(bmi >= 25) {
			System.out.printf("과체중입니다.");
		}else if(bmi >= 18.5) {
			System.out.printf("정상체중입니다.");
		}else {
			System.out.printf("저체중입니다.");
		}
		
		/* 문제4) 선택한 단의 6번째 값을 출력하도록 하세요.
		   예를 들어, 2단일 경우 2 X 6 = 12 
		   단, 출력문에 변수를 사용하지 않는다.
		 */
		int num;

		
		int score;
	}

}
