package homework2;

public class StandardWeightlnfo extends Human{

	public StandardWeightlnfo(String name, double height, double weight) {
		super(name, height, weight);
	}
	@Override
    public void getinformation() {
        super.getinformation(); // Human 클래스의 getinformation() 메소드 호출
        System.out.println("표준체중: " + getStandardWeight() + "kg");
    }
    public double getStandardWeight() {
        return (getHeight() - 100) * 0.9;
    }

}
