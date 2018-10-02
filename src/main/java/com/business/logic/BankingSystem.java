package com.business.logic;

public class BankingSystem {

	// dummy logic
	public double getBalance() throws Exception {
		double ret = 0.0;
		Thread.sleep(1000);
		ret = System.currentTimeMillis() / 10000;
		return ret;
	}

	// dummy logic
	public double debitBalance(double amt) throws Exception {
		Thread.sleep(1000);
		return (System.currentTimeMillis() / 10000) - amt;
	}
	
	// dummy logic
		public double creditBalance(double amt) throws Exception {
			Thread.sleep(800);
			return (System.currentTimeMillis() / 10000) + amt;
		}

}
