package com.yedam.java.ch04;

public class ConditonalExample {

	public static void main(String[] args) {
		// px ) 1 ~ 10사이의 정수들을 출력
		// 1,2,3,4,5,6,7,8,9,10
		for(int i = 1; i<=10; i++) {
			System.out.println(i);
		}
		
		int i = 1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}	
		// 1 ~ 10 사이의 모든 정수들의 합
		int sum = 0;	
		for(int a = 1; a<= 10 ;a++) {
			sum += a;
		}
		System.out.println("합계 : " + sum);
		
		sum = 0;
		int b = 1;
		while(b <= 10) {
			sum += b;
			b++;
		}
		System.out.println("합계 : " + sum);
		
		// do ~ while : 조건식이 false도 한번은 실행을 보장
		int index = 0;
		while(index < 0) {
			System.out.println("while 문, "+ index);
		}
		index = 0;
		do {
			System.out.println("do ~ while문, " + index);
		}while(index <0);
		
		// break; 문
		for(int x = 0; x < 100; x+=2) {
			if(x == 10) {
				break;
			}System.out.println(x);
		}
		while(true) {
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			if(num == 6) {
				break;
			}
		}
		System.out.println("------------------------");
		boolean isPrinted = false;
		for(char upper = 'A'; upper <= 'Z'; upper++) {
			for(char lower = 'a'; lower <='z'; lower++) {
				System.out.println(upper + " - " + lower);
				if(lower == 'g') {
					isPrinted = true;
					break;
				}
			}
			System.out.println("1 ) 안쪽 반복문 종료");
			if(isPrinted) {
				break;
			}
		}
		System.out.println("1 ) 바깥쪽 반복문 종료");
		
		
		System.out.println("------------------------");
		outter : for(char upper = 'A'; upper <= 'Z'; upper++) {
			for(char lower = 'a'; lower <='z'; lower++) {
				System.out.println(upper + " - " + lower);
				if(lower == 'g') {
					break outter;
				}
			}
			System.out.println("2 ) 안쪽 반복문 종료");
		}
		System.out.println("2 ) 바깥쪽 반복문 종료");
		// continue; 문
		for(int x= 1; x<=10; x++) {
			if(x%2 == 0) continue; // 짝수일경우
			System.out.println(x+", 해당 값은 짝수입니다.");
		}
		for(int x= 1; x<=10; x++) {
			if(x%2 == 1) { // 홀수일경우
			System.out.println(x+", 해당 값은 홀수입니다.");
			}
		}

		
	}

}
