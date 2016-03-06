import java.util.Scanner; // Class for input 

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Calculating square root
		int x;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Введите значение целого числа для вычисления его квадратного корня:");
		
		if(sc.hasNextInt()) {
			x = sc.nextInt();
	    } else {
	          System.out.println("Выполнение программы прекращено: значение x должно быть целым!");
	          sc.close();
	          return;
	    }
		sc.close();
		
		System.out.println("Результат вычисления квадратного корня: " + CalcSquareRoot(x));
	}
	public static int CalcSquareRoot(int x){

		int i = 1;
		int res;
		int cnt = 0;
		boolean flag = false;
		
		res = x;
		while(!flag){
			res = res-i;
			i = i + 2;
			cnt ++;
			flag = ((res < i)||(res == 0));
			System.out.println("res "+res+ " i "+i+" cnt "+cnt+" flag "+flag);
		};
		return cnt;
	}

}
