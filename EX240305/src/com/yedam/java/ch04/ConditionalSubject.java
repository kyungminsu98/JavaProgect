package com.yedam.java.ch04;

import java.util.Scanner;

public class ConditionalSubject {

	public static void main(String[] args) {

		// 문제1) 책 161페이지 5번, for문을 이용해서 다음과 같이 *를 출력하는 코드를 작성해보세요.
		// *
		// **
		// ***
		// ****
		// *****
		
		// 1)
		String tree ="";
		for(int i = 1; i <= 5;i++) {
			tree = tree +"*";
			System.out.println(tree);
		}
		// 2)
		for(int i = 1; i <= 5;i++) {
			for(int j=1; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// 문제2) 책 160페이지 2번, for문을 이용해서 1부터 100까지의 정수 중에서 2의 배수가 아닌 숫자의 개수를 구하세요.
		//		 단, continue 문을 사용한다.
		
		// 1)
		int count = 0;
		for(int i = 1; i<=100; i++) {
			if(i % 2 == 0) {
				continue;
			}
			count++;
		}System.out.println(count);
		
		// 2)
		int result = 0;
		for(int i = 1; i<=100; i++) {
			if(i%2 != 1) {
				continue;
			}result++; 
		}System.out.println(result);

		// 문제3) 책 161페이지 4번, 중첩 for문을 이용하여 방정식 4x+5y = 60의 모든 해 중 첫번째로 구해지는 값을 (x, y) 형태로 출력해보세요.
		//       단, x와 y는 10이하의 자연수입니다.
		
		boolean isSolution = false;
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%d, %d)\n", x, y);
					isSolution =true;
					break;
				}
			}if(isSolution) {
				break;
			}
		}
		
		// 문제4) do ~ while문과 Math.random()함수를 이용하여 1 ~ 10의 정수 중 7이라는 수가 나올때까지 숫자를 출력하는 코드를 작성해보세요.
		int num = 0;
		do {
			num = (int)(Math.random()*10)+1;
			System.out.println(num);
		}while(num != 7);
		
		// 문제5) 책 161페이지 3번, while문과 Math.random() 함수를 이용해서 2개의 주사위를 던졌을때 나오는 숫자를 (숫자1, 숫자2) 형태로 출력하고,
		//		 숫자의 합이 5가 아니면 계속 주사위를 던지고, 숫자의 합이 5이면 실행을 멈추는 코드를 작성해보세요.
		//		 또한 주사위를 몇번 던졌는지. 횟수를 출력하세요.
		//		 숫자의 합이 5가 되는 조합은 (1,4), (4,1), (2,3),(3,2)
		
		// 1)
		int  num2 = 0;
		int  num3 = 0;
		int count2 = 0;
		do {
			num2 = (int)(Math.random()*5)+1;
			num3 = (int)(Math.random()*5)+1;		
			count2++;
			System.out.println("(" + num2 + ", " + num3 + ")");
			System.out.println("주사위 횟수,"+ count2 + "회");
		}while(num2 +num3 != 5);
		
		// 2)
		int count5 = 0;
		while(true) {
			// 1.주사위를 굴리고
			int x = (int)(Math.random()*6)+1;
			int y = (int)(Math.random()*6)+1;
			// 2.나온 값을 출력 : (x, y)
			System.out.printf("(%d, %d)\n",x,y);
			// 3.주사위를 굴린 횟수 증가
			count5++;
			System.out.println("횟수"+count5);
			// 4.종료조건 확인
			if(x+y == 5) {
				break;
			}
		}
//		boolean run = true;
//		int balance = 0;
//		Scanner scanner = new Scanner(System.in);
//		
//		while(run) {
//			System.out.println("------------------------");
//			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
//			System.out.println("------------------------");
//			System.out.println("선택 >");
//			
//		}
//		System.out.println("프로그램 종료");
	}

}
