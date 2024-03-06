package com.yedam.java.ch0502;

import java.util.Arrays;

public class ReferenceSubject {

	public static void main(String[] args) {
		int[] arr1 = {10,20,30,50,3,60,-3};
		
		// 문제 1 주어진 배열 중에서 값이 60인 곳의 인덱스를 출력
		for(int i=0; i<=arr1.length-1; i++) {
			System.out.printf("%d, %d\n", i, arr1[i]);
			if(arr1[i] == 60) {
				System.out.println("해당 인덱스 : "+ i);
				break;
			}
		}
		System.out.println("=================");
		
		// 문제 2 주어진 배열 중에서 인덱스가 짝수인 값을 출력
		for (int i = 0; i < arr1.length; i++) {
//		    System.out.printf("%d, %d\n", i, arr1[i]);
		    if (arr1[i]%2 == 0) {
		        System.out.println("짝수에 해당하는 인덱스 : " + arr1[i]);
		    }
		}
		System.out.println("=================");
		// 문제 3 주어진 배열 중에서 최대값과 최소값을 출력
		int min =0;
		int max =0;
		for (int i = 0; i < arr1.length; i++) {
		    System.out.printf("%d, %d\n", i, arr1[i]);
		    if (arr1[i]>max) {
		    	max = arr1[i];
		    }if(arr1[i]<min) {
		    	min = arr1[i];
		    }
		}
		System.out.println("최댓값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("=================");
		
		// 향상된 for 문 사용 예시
		for(int temp :arr1) {
			if(max < temp) {
				max=temp;
			}
			if(temp < min) {
				min=temp;
			}
		}
//		System.out.printf("최소값 : %d 최대값 : %d", min,max);
		
		// 추가문제 내림차순으로 정렬
//		Arrays.sort(arr1);
//		System.out.println(Arrays.toString(arr1));
		for(int i=0;i<=arr1.length-1;i++) {
			// i : 배열의 현재 위치
			// arr1[i] => 현재 최대값
//			System.out.printf("인덱스 : %d, 현재 값 : %d\n", i, arr1[i]);
			for(int j=i+1;j<=arr1.length-1;j++) {
				// j : i와 비교하는 값의 위치
//				System.out.printf(" === 비교 값 ㅣ %d\n", arr1[j]);
				if(arr1[i] < arr1[j]) {
					int temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
				
			}
		}
		for(int temp : arr1) {
			System.out.print(temp + ", ");
		}
	}

}
