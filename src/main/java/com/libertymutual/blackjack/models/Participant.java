package com.libertymutual.blackjack.models;

public class Participant {
	
	private Hand hand;
	private Wallet wallet;
	
	
	public Participant(Wallet wallet, Hand hand) {
		
		this.hand = new Hand();
		this.wallet = wallet;
		
	}
	
	public void bet(int value) {
		wallet.betAmount(value);
		wallet.getTotalMoney();

		
	}
	
	public void hit() {
		hand.getValues();
		hand.getCards();
		
	}
	
	
	public void bust() {
		
		
	}
	
	public void stand() {
		
		
	}

}
