package homework2;

public class Human {
    protected String name;
    protected double height;
    protected double weight;

    public Human(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public void getinformation() {
    	System.out.print("이름 : " + this.name + " 키 : " + this.height + " 몸무게 : " + this.weight);
    }
}
