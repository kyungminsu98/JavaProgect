package com.yedam.java.homework;

public class ObesityInfo extends StandardWeightInfo {

	public ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	@Override
	public void getInformation() {
		System.out.println(this.name + "님의 신장 " + this.height + ", 몸무게 " + this.weight +", " + getObesity() +"입니다.");
	}
	
	public String getObesity() {
		double bmi = (this.weight - this.getStandardWeight())/this.getStandardWeight() * 100;
		String obesity = null;
		if(bmi <= 18.5) {
			obesity = "저체중";
		}else if(bmi <= 22.9) {
			obesity = "정상";
		}else if(bmi <= 24.9) {
			obesity = "과체중";
		}else {
			obesity = "비만";
		}
		
		return obesity;
	}

}
