package collections;
import java.util.*;

public class Abonent {
	public String name;
	public long phone;
	
	public Abonent(String name, long phone){
		this.name=  name;
		this.phone= phone;
	}
	@Override
	public String toString(){
		return this.name + " : " + this.phone;
	} 

	public static void main(String[] args) {
		Random random = new Random();
		String namePrefix = "Abonent#", phoneNumberPrefix = "89", phoneNumber;
		long currentTime = System.currentTimeMillis(), numAbonents = 1000000;
		int maxRandom = Integer.MAX_VALUE, cnt = 0;
		
		// Реализация с использованием списка
		List<Abonent> abonents = new ArrayList<Abonent>();
		for(long idx=0; idx< numAbonents; idx++){
			phoneNumber = phoneNumberPrefix + random.nextInt(maxRandom);
			abonents.add(new Abonent(namePrefix + Long.toString(idx), Long.valueOf(phoneNumber)));
		}
		
		List<Long> specialNumbers = new ArrayList<Long>();
		for(Abonent abonent : abonents){
			specialNumbers.add(abonent.phone);
			cnt++;
			if(cnt>=10) break;
		}
		System.out.println("Номера, которые будем искать в нашей коллекции:");
		System.out.println(specialNumbers);
		
		System.out.println("Время выполнения программы: "+ (System.currentTimeMillis() - currentTime));
	}

}
