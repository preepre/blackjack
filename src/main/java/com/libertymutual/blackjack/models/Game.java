package com.libertymutual.blackjack.models;

public class Game {
	
	private int playerWon;
	private int playerHand1;
	private int playerHand2;
	private int dealerHand1;
	private int dealerHand2;
	private int betAmount;
	
	public Game () {
		
	}
	
	public String getWinner(int intWinner) {
		playerWon = intWinner;
		
		if(playerWon == 0) {
			return "Congratulations, you beat the Dealer!";
		} 
		else if(playerWon == 1) {
			return "Sorry, you lost! Try again? Mwuahaha!";
		}
		else if(playerWon == 2){
			return "Tie! You and the Dealer are even.";
		}
		return "Not sure";						
	}
	
	public int finalPayout(int playerHand1, int playerHand2, int dealerHand1, int dealerHand2, int betAmount) {
		this.playerHand1 = playerHand1;
		this.dealerHand1 = dealerHand1;
		this.betAmount = betAmount;
		
		if(playerHand1 > 21 || playerHand2 > 21) {
			return betAmount * -1; //lose bet
		} 
		else if (((playerHand1 == 21 || playerHand2 == 21)) && ((dealerHand1 != 21 && dealerHand2 != 21))) {
			return betAmount; //keep bet
		}
		else if((playerHand1 == 21 || playerHand2 == 21) && (dealerHand1 == 21 || dealerHand2 == 21)) {
			return betAmount; //keep money //tie
		}
		else if((dealerHand1 > 21 && dealerHand2 > 21) && (playerHand1 <= 21 || playerHand2 <= 21)) {
			return betAmount * 2;
		}
		else if((dealerHand1 < playerHand1 && playerHand1 <= 21)|| (dealerHand1 < playerHand2 && playerHand2 <= 21) || (dealerHand2 < playerHand1 && playerHand1 <= 21) || (dealerHand2 < playerHand2 && playerHand2 <= 21)) {
			return betAmount * 2;
		}
		else if(( playerHand1 < dealerHand1 && dealerHand1 <= 21 ) || (playerHand2 < dealerHand1 && dealerHand1 <= 21 ) || (playerHand1 < dealerHand2 && dealerHand2 <= 21 ) || ((playerHand2 < dealerHand2 && dealerHand2 <= 21 )) ) {
			return betAmount * -1; //lose bet
		}
		else {
			return betAmount;
		}
		
		
	}

}
