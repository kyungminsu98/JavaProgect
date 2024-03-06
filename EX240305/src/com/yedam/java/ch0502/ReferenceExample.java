package com.yedam.java.ch0502;

public class ReferenceExample {

	public static void main(String[] args) {
		// 배열의 변수 선언 & 초기화
		int[] intAry = {1, 10, 25}; // 선언과 동시에 값 할당 
		double[] doubleAry;
		doubleAry = new double[] {25.3, 55.9}; // 객체를 생성 후 값 할당
		String[] strAry = new String[3]; // new 연산자 사용

		for(int i = 0;i<intAry.length ;i++) {
			System.out.print(intAry[i]+" ");
		}
		System.out.println("");
		for(int i = 0;i<=strAry.length-1 ;i++) {
			System.out.print(strAry[i]+" ");
		}
		System.out.println("");
		System.out.println(doubleAry[0]);
		
		System.out.println("=================");
		// 2차원 배열
		int[][] intList = {{1,2,3},{5,6,7}};
		System.out.println("intList.length : "+ intList.length);
		System.out.println("intList[0].length : "+ intList[0].length);
		
		for(int i=0; i<=intList.length-1;i++) {
//			intList[i]; => 1차원 배열
			for(int j=0;j<=intList[i].length-1 ;j++) {
				// intlist[i][j] => int 타입
				System.out.printf("instList[%d][%d] : %d\n",i,j,intList[i][j]);
			}
		}
		
		String[][] strList = new String[2][3];
		System.out.println("strList.length : "+ strList.length);
		String[] strAray = strList[0];
		System.out.println("strList.length : "+ strList.length);
		System.out.println("strList[0].length : "+ strList[0].length);
		
		System.out.println("=================");
		// 참조타입배열 & 복사
		intList = new int[][]{{1,2,3},{5,6,7}};
		int[][] newList =new int[2][3]; 
		
		// 얕은복사 : 주소값 복사
		for(int i = 0; i<=intList.length;i++) {
			
		}
		System.out.printf("intList : %d, newList : %d\n", intList, newList);
		newList[1][0]= 10;
		System.out.printf("intList : %d, newList : %d\n", intList, newList);
		// 깊은 복사 : 실제값 복사
		for(int i = 0; i<=intList.length;i++) {
			for(int j = 0; j<=intList.length;j++) {
				newList[i][j]= intList[i][j];
			}
		}
		System.out.printf("intList : %d, newList : %d\n", intList, newList);
		newList[1][0]= 1234;
		System.out.printf("intList : %d, newList : %d\n", intList, newList);

		int[] aray= {1,2,5,7,8};
		for(int i=0; i<=aray.length-1;i++) {
			System.out.printf("인덱스 : %d, 값 : %d\n", i, aray[i]);
		}
		for(int temp : aray) {
			System.out.println(temp);
		}
	}
}
