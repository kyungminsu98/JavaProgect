package com.yedan.java.ch03;

import java.util.Scanner;

public class OperatorExample {

	public static void main(String[] args) {
		/* 부호연산자*/
		int a = -100;     // -(100)
		int result1 = -a; // -(-100)
		int result2 = +a; // +(-100) 
		System.out.println("res1 : "+ result1);
		System.out.println("res2 : "+ result2);
		
		byte b = -100;
		int result3 = -b;// -(-100) = +100(int)
		System.out.println("res3 : "+ result3);
		
		/* 증감연산자 */
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("--------------------");
		x++; // x = x + 1;
		System.out.println("x : " + x);
		++x; // x = 1 + x;
		System.out.println("x : " + x);
		
		// y = y - 1;
		y--;
		System.out.println("y : " + y);
		--y;
		System.out.println("y : " + y);
		System.out.println("--------------------");
		
		z = x++; // z : 12  , x : 13
		System.out.printf("z : %d, x : %d \n", z, x);
		z = ++x; // z : 14  , x : 14
		System.out.printf("z : %d, x : %d \n", z, x);
		
		System.out.println("--------------------");
		x = 5;
		y = 5;
		
		z = ++x + y--;
		System.out.printf("z : %d, x : %d, y: %d\n", z, x, y);

		/* 산술연산자 */
		int e = 10;
		int f = 3;
		int g;
		
		g = e / f; // 몫
		System.out.println("g : " + g);
		
		g = e % f; // 나머지
		System.out.println("g : " + g);
		
		/* 비교연산자 & 논리연산자 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력> ");
		String value = sc.nextLine();
		
		char charVal = value.charAt(0); 
		
		// 대문자 : 유니코드 중 65보다 크거나 같으며 90보다 작거나 같은 경우
		// 산수 65 <= 비교값 <= 90
		// 1) 비교값 >= 65
		// 2) 비교값 <= 90
		// 3) 1) && 2)
		if((charVal >= 65) && (charVal <= 90)) {
			System.out.println("입력한 값은 대문자입니다.");
		}
		// 소문자 : 유니코드 중 97보다 크거나 같으며 122보다 작거나 같은 경우
		// 1) 비교값 >= 97
		// 2) 비교값 <= 122
		if((charVal >= 97) && (charVal <= 127)) {
			System.out.println("입력한 값은 소문자입니다.");
		}
		// 숫자 0 ~ 9 : 유니코드 중 47보다 크고 58보다 작은 경우
		// 1) 비교값 > 48
		// 2) 비교값 < 57
		if(charVal > 47 & charVal < 58) {
			System.out.println("입력한 값은 숫자입니다.");
		}
		sc.close();
		System.out.println("--------------------");
		
		/* 복합대입연산자 */
		int res = 10;
		res += 10; // res = res + 10; => res =+ 10;
		System.out.println(res);
		res *= 2;  // res = res * 2;
		System.out.println(res);
		res /= 3;  // res = res / 3;
		System.out.println(res);
		res %= 4;  // res = res % 4;
		System.out.println(res);
		
		/* 삼항 연산자 */
		String result = (res > 10) ? "A" : "B";
		if(res > 10) {
			result = "A";
		}else {
			result = "B";
		}
		System.out.println("result : " + result);
		
	}

}
