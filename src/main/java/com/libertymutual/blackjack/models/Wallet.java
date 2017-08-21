package com.libertymutual.blackjack.models;

public class Wallet {
	
	private int dinero;
	private int betAmount;
	private int initialAmount;
	
	
	public Wallet() {

		dinero = 1000;	
		betAmount = 0;
		
	}
	
	public int getTotalMoney() {
		return dinero;
		//change all this
	}
	
	
	public int betAmount(int value) {
		betAmount = value;
		dinero -= betAmount;
		return dinero;
		
	}
	
	//add amount won to current amount in wallet
	public void won(int value) {
		dinero += value;
		
	}

	
	public void clear() {
		dinero = 1000;
	}
	
	

}
