
public class CircleArea {
	public static void main(String[] args){
		double R = Double.parseDouble(args[0]);
		System.out.println("Circle area= " + CalcCircleArea(R));
	}
	// Процедура вычисления площади круга
	public static double CalcCircleArea(double R){
		double Pi = 3.14;
		return Pi * R * R;
	}
}