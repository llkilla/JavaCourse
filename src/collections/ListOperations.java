package collections;
import java.util.*;

public class ListOperations {

	public static void main(String[] args) {
		int listSize = 10, maxElem = 100;
		
		List<Integer> intList = new ArrayList<Integer>();
		Random random = new Random();
		
		for(int i=0; i< listSize; i++){
			intList.add(random.nextInt(maxElem));
		}
		System.out.println("Элементы списка: ");
		System.out.println(intList);
		
		// Коллекция удаляемых элементов
		List<Integer> removedObject = new ArrayList<>();
		for (Integer e : intList){
			if (intList.indexOf(e) % 2 == 1){
				removedObject.add(e);
			}
		}
		// Удаление эл-нтов с помощью итератора для избежания ошибки ConcurrentModoficationException
		for(Iterator<Integer> iter = intList.iterator(); iter.hasNext();){
			int idx = iter.next();
			if(removedObject.contains(idx)){
				iter.remove();
			}
		}
		System.out.println("Элементы списка после удаления элементов на нечетных позициях (Нумерация начинается с нуля): ");
		System.out.println(intList);
	}

}
