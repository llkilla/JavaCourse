package Parallel;

import java.util.ArrayList;
import java.util.List;

public class DepositTest {

	public static void main(String[] args) {
		Deposit clientDeposit = new Deposit("40817810099910004312");
		Thread salaryThread, spenderThread;
		
		clientDeposit.setRestSum(10000); 
		
		List<Thread> threadList = new ArrayList<Thread>();
		
		for (int i = 0; i < 6; i++){
			
			salaryThread = new Thread(new Salary(clientDeposit));
			threadList.add(salaryThread);
			
			spenderThread = new Thread(new Spender(clientDeposit, 3000));
			threadList.add(spenderThread);
			
			salaryThread.start();
			spenderThread.start();
			
		}
		
		for(Thread thread : threadList){
			if(thread.isAlive())
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
		clientDeposit.printRestSum();
	}
	
	static class Salary implements Runnable {
		
		private Deposit deposit;
		
		public static final int AMOUNT = 30000;

		public Salary(Deposit dep){
			this.deposit = dep;
		}
		
		@Override
		public void run() {
			deposit.modifyRest(AMOUNT);
		}
	}
	
	static class Spender implements Runnable {
		
		private Deposit deposit;
		private int summa;

		public Spender(Deposit dep, int summa){
			this.deposit = dep;
			this.summa = summa;
		}
		
		@Override
		public void run() {
			deposit.modifyRest(-1 * summa);
		}
	}
}
