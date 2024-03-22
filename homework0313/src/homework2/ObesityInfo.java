package homework2;

public class ObesityInfo extends StandardWeightlnfo{
	public ObesityInfo(String name, double height, double weight) {
        super(name, height, weight);
    }
    @Override
    public void getinformation() {
        System.out.printf("%s님의 신장 %d, 몸무게 %.1f, 표준체중 %.1f 입니다.\n", getName(), (int)getHeight(), getWeight(), getStandardWeight());
    }
    // 표준체중
    public double getStandardWeight() {
        return (getHeight() - 100) * 0.9;
    }

    public static void main(String[] args) {
        Human human = new ObesityInfo("홍길동", 168, 45);
        human.getinformation();

        human = new StandardWeightlnfo("박둘이", 168, 90);
        System.out.printf("%s님의 신장 %d, 몸무게 %.1f, 비만입니다.\n", human.getName(), (int)human.getHeight(), human.getWeight());
    }
}

