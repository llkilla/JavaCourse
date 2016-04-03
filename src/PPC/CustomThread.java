package PPC;

public class CustomThread extends Thread{
	private Vehicle vehicle;
	
	public CustomThread(String name, Vehicle vehicle){
		this.setName(name);
		this.vehicle = vehicle;
	}
	
	@Override
	public void run(){
		try {
			System.out.println("starting thread : " + this.getName());
			vehicle.calculateBill();
		} catch (CheckYourAutoException e) {
			System.out.println(e.toString());
		}
	}
}

