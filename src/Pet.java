
public abstract class Pet {
	private int Age;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private boolean isHungry;

	public boolean isHungry() {
		return isHungry;
	}

	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}

	public void Eat(Men aMen){
		aMen.Feed(this);
	}
	
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
