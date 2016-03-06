
public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Shows prime numbers in interval 1..1000
		System.out.print("Простые числа от 1 до 1000: ");
		
		for (int i = 1; i < 1000; i++){
			if (IsPrime(i)){
				System.out.print(i + " ; ");
			}
		}
	}
	public static boolean IsPrime(int x){
		boolean res = true;
		
		if ((x == 1)||(x == 2)){
			res = false;
		} else {
			for (int idx = 2; idx < x; idx++){
				if (x % idx == 0){
					res = false;
					break;
				} 
			}
		}
		return res;
	}

}
