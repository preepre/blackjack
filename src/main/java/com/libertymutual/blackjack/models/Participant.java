package com.libertymutual.blackjack.models;

public class Participant {
	
	private Hand hand;
	private Wallet wallet;
	
	
	public Participant(Wallet wallet) {
		
		hand = new Hand();
		this.wallet = wallet;
		
	}
	
	public void bet(int value) {
		wallet.setValueToBeUpdated(value);
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
