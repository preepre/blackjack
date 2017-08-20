package com.libertymutual.blackjack.models;

public class Wallet {
	
	private int dinero;
	private int betAmount;
	private int initialAmount;
	
	
	public Wallet() {

		dinero = 100;	
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
	
	public void won(int value) {
		this.betAmount(dinero + betAmount);
		this.getTotalMoney();
		
	}
	
	public void lost(int value) {
		
		while (dinero > 0) {
			this.betAmount(dinero - betAmount);
			this.getTotalMoney();
		}
		
		System.out.println("You have no money left");
						
	}
	
	public void clear() {
		dinero = 100;
	}
	
	

}
