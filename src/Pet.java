
public abstract class Pet {
	private int Age;

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}
	public abstract void Voice();
	
	public void beOlder(){
		this.Age += 1;
	}
	public void beOlder(int cnt){
		this.Age += cnt;
	}
}
