package collections;
import java.util.*;

public class SetOperations {
	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
		Set<Integer> unitedSet = new HashSet<Integer>();
		
		unitedSet.addAll(set1);
		unitedSet.addAll(set2);
		return unitedSet;
	}
	public static Set<Integer> intersect(Set<Integer> set1, Set<Integer> set2){
		Set<Integer> intersectedSet = new HashSet<Integer>();
		
		intersectedSet.addAll(set1);
		intersectedSet.retainAll(set2);
		return intersectedSet;
	}
	public static void main(String[] args) {
		Set<Integer> setA = new HashSet<Integer>(), setB = new HashSet<Integer>();
		Random random = new Random();
		int maxElem, setASize, setBSize;
		
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Укажите максимальное значение целочисленного элемента множества: ");
			maxElem = sc.nextInt();
		
			System.out.print("Укажите число элементов множества А: ");
			setASize = sc.nextInt();
			
			System.out.print("Укажите число элементов множества В: ");
			setBSize = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.print("Выполнение программы прекращено: при попытке чтения данных с консоли произошла ошибка. Проверьте корректность введенных данных. ");
			return;
		}
		
		for(int i=0; i<setASize; i++){
			setA.add(random.nextInt(maxElem));
		}
		System.out.println("Элементы множества А: ");
		System.out.println(setA);
		
		for(int i=0; i<setBSize; i++){
			setB.add(random.nextInt(maxElem));
		}
		System.out.println("Элементы множества В: ");
		System.out.println(setB);
		System.out.println("Элементы множества, являющегося объединением множеств А и В: ");
		System.out.println(union(setA, setB));
		System.out.println("Элементы множества, являющегося пересечнием множеств А и В: ");
		System.out.println(intersect(setA, setB));
	}

}
