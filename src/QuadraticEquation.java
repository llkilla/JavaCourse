import java.util.Scanner; // Class for input 
public class QuadraticEquation {

	public static void main(String[] args) {
		// TODO Solving the quadratic equation
		int a;
		int b;
		int c;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите значение а:");
		if(sc.hasNextInt()) {
			a = sc.nextInt();
	    } else {
	          System.out.println("Выполнение программы прекращено: значение а должно быть целым!");
	          sc.close();
	          return;
	    }
		
		System.out.print("Введите значение b:");
		if(sc.hasNextInt()) {
			b = sc.nextInt();
		} else {
			System.out.println("Выполнение программы прекращено: значение b должно быть целым!");
			sc.close();
			return;
		}
		
		System.out.print("Введите значение c:");
		if(sc.hasNextInt()) {
			c = sc.nextInt();
		} else {
			System.out.println("Выполнение программы прекращено: значение с должно быть целым!");
			sc.close();
			return;
		}
		
		sc.close();
		
		SolveEquation(a, b, c);
	}
	public static void SolveEquation(int a, int b, int c){
		double Discr;
		double x1;
		double x2;
		
		if (a == 0){
			System.out.println("Первый коэффициент не может быть 0!");
			return;
		};
		Discr = Math.pow(b, 2) - 4*a*c;
		if (Discr < 0) {
			System.out.println("Нет действительных решений уравнения!");
			return;
		}
		else if (Discr == 0){
			x1 = -b/(2*a);
			System.out.println("Уравнение имеет единственное решение: x1 = x2 = " + x1);
			
		}
		else {
			x1 = -(b + Math.sqrt(Discr))/(2*a);
			x2 = -(b - Math.sqrt(Discr))/(2*a);
			System.out.println("Уравнение имеет два различных решения: x1 = " + x1 + ", x2 = " + x2);
		};
	}
}
