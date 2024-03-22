package com.yedam.java.homework;

public class StandardWeightInfo extends Human {

	public StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	@Override
	public void getInformation() {
		super.getInformation();
		System.out.printf( ", 표준체중 %.1f 입니다.\n", getStandardWeight());
		
	}
	
	public double getStandardWeight() {
		return (double)((this.height - 100) * 0.9);
	}

}
