package com.libertymutual.blackjack.models;

import java.util.ArrayList;
import java.util.List;


public class Hand {
	
	ArrayList<Card> cards;
	Wallet wallet;

	
	
	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public int[] getValues() {
		
		int[] sums = new int[] { 0, 0 };
		
		for (Card c : cards) {
			int[] values = c.getValues();
			sums[0] += values[0];
			sums[1] += values[1];
		}
		
		return sums;
	}

	public boolean isBust() {
		int[] handValues = this.getValues();
		
		if(handValues[0] > 21 && handValues[1] > 21) {
			return true;
		}
		
		return false;
	}

	public int getBestValue() {
		
		int[] handValues = this.getValues();
		
		if (handValues[0] > handValues[1] && handValues[0] <= 21) {
			return handValues[0];
		} else if (handValues[1] > handValues[0] && handValues[1] <= 21) {
			return handValues[1];
		}
//		for (int i : sums) {
//		if (i <= 21)
//	}
		return 0;
		
	}

	public boolean isBlackjack() {
		int[] handValues = this.getValues();
		
		if(handValues[0] == 21 || handValues[1] == 21) {
			return true;
		}
		
		return false;
	}
	
		
	
}