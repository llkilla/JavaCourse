package PPC;

import PPC.Vehicle.specCat;

public class WorkRegime {

	public static void main(String[] args) {
		double lowSpeed = 75.0;
		double lowHeight = 2.5;
		double lowCarrying = 8.0;
		double averageSpeed = 120.0;
		double highSpeed = 200.0;
		double highCarrying = 25.0;
		double highHeight = 5.0;
		
		Vehicle auto1 = new PassengerCar(lowSpeed);
		Vehicle auto2 = new PassengerCar(averageSpeed);
		Vehicle auto3 = new PassengerCar(highSpeed);
		
		try{
			auto1.calculateBill();
		}
		catch(CheckYourAutoException e){
			System.out.println(e.toString());
		};
		try{
			auto2.calculateBill();
		}
		catch(CheckYourAutoException e){
			System.out.println(e.toString());
		};
		try{
			auto3.calculateBill();
		}
		catch(CheckYourAutoException e){
			System.out.println(e.toString());
		};
		Vehicle auto4 = new Truck(lowSpeed, lowHeight, lowCarrying, false);
		Vehicle auto5 = new Truck(lowSpeed, lowHeight, lowCarrying, true);
		Vehicle auto6 = new Truck(lowSpeed, lowHeight, highCarrying, false);
		Vehicle auto7 = new Truck(lowSpeed, highHeight, lowCarrying, false);
		
		try{
			auto4.calculateBill();
		}
		catch(CheckYourAutoException e){
			System.out.println(e.toString());
		};
		try{
			auto5.calculateBill();
		}
		catch(CheckYourAutoException e){
			System.out.println(e.toString());
		};
		try{
			auto6.calculateBill();
		}
		catch(CheckYourAutoException e){
			System.out.println(e.toString());
		};
		try{
			auto7.calculateBill();
		}
		catch(CheckYourAutoException e){
			System.out.println(e.toString());
		};
		Vehicle auto8 = new Truck(lowSpeed, highHeight, lowCarrying, false);
		auto8.setSpec(specCat.FIRE);
		
		try{
			auto8.calculateBill();
		}
		catch(CheckYourAutoException e){
			System.out.println(e.toString());
		};
	}

}
