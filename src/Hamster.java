
public class Hamster extends Pet{
	char Gender;
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	@Override
	public void Voice(){
		System.out.println("Hamster says nothing");
	};
}
