package com.shash.threads.f_reentrant_locks.waitNotifyEquivalent;


public class WaitNotifyEquivalentDemo {

	public static void main(String[] args) {

		final BankingSimulator bankingSimulator = new BankingSimulator();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					bankingSimulator.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					bankingSimulator.secondThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try{
			t1.join();
			t2.join();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		bankingSimulator.finalTotalBalance();
		
		
	}

}
