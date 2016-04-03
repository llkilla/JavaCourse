package PPC;

import PPC.Vehicle.specCat;

public class ParallelRegime {
	
	public static void main(String[] args) {
		double lowSpeed = 75.0;
		double lowHeight = 2.5;
		double lowCarrying = 8.0;
		double averageSpeed = 120.0;
		double highSpeed = 200.0;
		double highCarrying = 25.0;
		double highHeight = 5.0;
		
		Vehicle auto1 = new PassengerCar("auto1", lowSpeed);
		Vehicle auto2 = new PassengerCar("auto2", averageSpeed);
		Vehicle auto3 = new PassengerCar("auto3", highSpeed);
		
		Vehicle auto4 = new Truck("auto4",lowSpeed, lowHeight, lowCarrying, false);
		Vehicle auto5 = new Truck("auto5",lowSpeed, lowHeight, lowCarrying, true);
		Vehicle auto6 = new Truck("auto6",lowSpeed, lowHeight, highCarrying, false);
		Vehicle auto7 = new Truck("auto7",lowSpeed, highHeight, lowCarrying, false);
		Vehicle auto8 = new Truck("auto8",lowSpeed, highHeight, lowCarrying, false);
		
		auto8.setSpec(specCat.FIRE);
		
		CustomThread thread1 = new CustomThread("#1", auto1);
		CustomThread thread2 = new CustomThread("#2", auto2);
		CustomThread thread3 = new CustomThread("#3", auto3);
		
		CustomThread thread4 = new CustomThread("#4", auto4);
		CustomThread thread5 = new CustomThread("#5", auto5);
		CustomThread thread6 = new CustomThread("#6", auto6);
		CustomThread thread7 = new CustomThread("#7", auto7);
		CustomThread thread8 = new CustomThread("#8", auto8);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
	}

}
