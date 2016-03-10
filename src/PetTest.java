
public class PetTest {
	public static void main(String[] args) {
		
		/*Creating a cat*/
		Pet c = new Cat();
		
		c.setName("Barsik");
		c.setAge(11);
		c.setHungry(true);
		((Cat) c).setVaccinated(true);
		
		/* Creating a dog*/
		Pet d = new Dog();
		
		d.setName("Sharik");
		d.setAge(3);
		d.setHungry(false);
		((Dog) d).setHunter(false);
		((Dog) d).setWeight(61);
		
		/* Creating a Hamster*/
		Pet h = new Hamster();
		
		h.setName("Fluffy");
		h.setHungry(true);
		((Hamster) h).setAge(1);
		((Hamster) h).setGender('F');
		
		/* Creating array of pets*/
		Pet[] myPets = new Pet[] {c, d, h};
		for (Pet thisPet : myPets){
			thisPet.Voice();
		}
		/* Getting older*/
		c.beOlder();
		System.out.println("Barsik is age of " +c.getAge());
		
		d.beOlder(2);
		System.out.println("Sharik is age of " +d.getAge());
		
		h.beOlder(1);
		System.out.println("Fluffy is age of " +h.getAge());
		
		/* Creating a man*/
		Men m = new Men();
		m.setName("Doctor Pavlov");
		
		c.Eat(m);
		d.Eat(m);
		h.Eat(m);
		
	};
}
