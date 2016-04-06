package Parallel;

public class Deposit {

	String accountNumber;
	int restSum;
	
	public Deposit(String number){
		this.accountNumber = number;
		this.restSum = 0;
	}
	
	public int getRestSum() {
		return restSum;
	}
	
	public void setRestSum(int restSum) {
			this.restSum = restSum;
	}
	public void printRestSum() {
	
		System.out.println("current rest is " + this.restSum);
		
	}
	public void modifyRest(int value){
		
		System.out.println("modyfying rest on "+value);
		synchronized(this){
			this.restSum+= value;
			}
	}
}
