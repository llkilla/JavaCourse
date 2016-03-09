
public class Dog extends Pet{
	boolean isHunter;
	double weight;
	
	public boolean isHunter() {
		return isHunter;
	}

	public void setHunter(boolean isHunter) {
		this.isHunter = isHunter;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public void Voice(){
		System.out.println("Dog says \"Woof\"");
	};
}
