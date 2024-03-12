package com.yedam.java.ch0604;

import java.util.Scanner;

public class VendingExample {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 > ");
		int menu = sc.nextInt();
		
		//String getBeverage(int menu){}; 
		String product = vm.getBeverage(menu);
		
		//void println(String x)
		System.out.println(product);
		
		sc.close();

	}

}
