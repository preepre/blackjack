package com.libertymutual.blackjack.models;

public class Wallet {
	
	private int dinero;
	private int betAmount;
	
	
	public Wallet() {

		dinero = 100;	
		betAmount = 0;
		
	}
	
	public int getTotalMoney() {
		return dinero;
		//change all this
	}
	
	public void setValueToBeUpdated(int value) {
		betAmount = value;
		
	}
	
	public void won(int value) {
		this.setValueToBeUpdated(dinero + betAmount);
		this.getTotalMoney();
		
	}
	
	public void lost(int value) {
		
		while (dinero > 0) {
			this.setValueToBeUpdated(dinero - betAmount);
			this.getTotalMoney();
		}
		
		System.out.println("You have no money left");
						
	}
	
	

}
