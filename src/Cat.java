
public class Cat extends Pet {
	boolean isVaccinated;
	
	public boolean isVaccinated() {
		return isVaccinated;
	}

	public void setVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}

	@Override
	public void Voice(){
		System.out.println("Cat says \"Meow\"");
	};
}
