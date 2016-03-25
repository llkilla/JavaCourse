package collections;
import java.util.*;

public class Employee {
	public String name;
	public int experience;
	public Employee(String name, int experience){
		this.name = name;
		this.experience = experience;
	}
	@Override
	public String toString(){
		return this.name + " : " + this.experience;
	}
	
	public static void printEmployee(List<Employee> employees, int workAge){
		Iterator<Employee> it = employees.iterator();
		Employee emp;
		while(it.hasNext()){
			emp = it.next();
			if(emp.experience == workAge){
				System.out.print(emp.name + "; ");
			}
		}
	}

	public static void main(String[] args) {
		int empCount = 10, maxExperience = 20, printExperience;
		String name = "Employee";
		
		Random random = new Random();
		List<Employee> employees = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i< empCount; i++){
			employees.add(new Employee(name + i, random.nextInt(maxExperience)));
		}
		System.out.println("Коллекция employees, заполненная случайным образом (имя : стаж работы): ");
		for(Employee e : employees){
			System.out.println(e.toString());
		}
		System.out.println("Введите стаж работы (целое число) для печати работников, имеющих стаж, равный введенному: ");
		try{
			printExperience = sc.nextInt();
			System.out.println("printExperience " + printExperience);
		} catch(InputMismatchException e){
			System.out.println("Введены некорректные данные. Выполнение программы прекращено.");
			return;
		} finally { 
			sc.close();
		}
		System.out.println("Служащие, имеющие стаж в годах, равный "+printExperience);
		printEmployee(employees, printExperience);
	}

}
