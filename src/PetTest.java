
public class PetTest {
	public static void main(String[] args) {
		// Надо ли определять тип как Pet и использовать конструктор Cat?
		Cat Barsik = new Cat();
		Barsik.setAge(11);
		Barsik.setVaccinated(true);
		
		Dog Sharik = new Dog();
		Sharik.setAge(3);
		Sharik.setHunter(false);
		Sharik.setWeight(61);
		
		Hamster Fluffy = new Hamster();
		Fluffy.setAge(1);
		Fluffy.setGender('F');
		
		Pet[] myPets = new Pet[] {Barsik, Sharik, Fluffy};
		for (Pet thisPet : myPets){
			thisPet.Voice();
		}
		//Gettin older
		Barsik.beOlder();
		System.out.println("Barsik is age of " +Barsik.getAge());
		
		Sharik.beOlder(2);
		System.out.println("Sharik is age of " +Sharik.getAge());
		
		Fluffy.beOlder(1);
		System.out.println("Fluffy is age of " +Fluffy.getAge());
	};
}
