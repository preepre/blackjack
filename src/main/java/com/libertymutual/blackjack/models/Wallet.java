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
	
	public int setTotalMoney(int value) {
		initialAmount = value;
		return initialAmount;
		//change all this
	}
	
	public int betAmount(int value) {
		betAmount = value;
		dinero -= betAmount;
		return dinero;
		
	}
	
	public int won(int value) {
		return betAmount + value; 
		
	}
	
	public void lost(int value) {
		this.betAmount(dinero - betAmount);
		this.getTotalMoney();
						
	}
	
	public void clear() {
		dinero = 100;
	}
	
	

}
