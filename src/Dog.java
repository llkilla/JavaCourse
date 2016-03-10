
public final class Dog extends Pet{
	boolean isHunter;
	double weight;
	
	public final boolean isHunter() {
		return isHunter;
	}

	public final void setHunter(boolean isHunter) {
		this.isHunter = isHunter;
	}

	public final double getWeight() {
		return weight;
	}

	public final void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public final void Voice(){
		System.out.println("Dog says \"Woof\"");
	};
}
