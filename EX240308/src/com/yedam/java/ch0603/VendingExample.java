package com.yedam.java.ch0603;

import java.util.Scanner;

public class VendingExample {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 >");
		int menu = sc.nextInt();
		
		// String getBeverage(int menu){} 를 가지고있음.
		String product = vm.getBeverage(menu);
		System.out.println(product);
		
		sc.close();
	}

}
