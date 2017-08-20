package com.libertymutual.blackjack.models;

public class Deck {
	
	private Card[] cards;
	private int currentCardIndex;
	
	public Deck() {
		String[] suites = new String[] {"Diamonds", "Clubs", "Spades", "Hearts"};
		int i = 0;
		cards = new Card[52];
		currentCardIndex = 0;
		
		for(String suite : suites) {
			cards[i] = new AceCard(suite);
			i++;
			
			cards[i] = new FaceCard("Jack", suite);
			i++;
			
			cards[i] = new FaceCard("Queen", suite);
			i++;
			
			cards[i] = new FaceCard("King", suite);
			i++;
			
			for (int j = 2; j < 11; j++) {
				cards[i] = new NumberCard(j, suite);
				i++;
			}
		}
		
	}
	
	public void printThis() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
	
	public Card getCard() {
		if(currentCardIndex >= cards.length) {
			return null;
		}
		
		Card cardToReturn = cards[currentCardIndex];
		currentCardIndex++;
		return cardToReturn;
		
	}
	
	
	public void shuffle() {
		for (int doThisSevenTimes = 0; doThisSevenTimes < 7; doThisSevenTimes += 1) {			
			Card[] tempCardHolder1 = new Card[26];
			Card[] tempCardHolder2 = new Card[26];
			
			for (int i = 0; i < tempCardHolder1.length; i += 1) {
				tempCardHolder1[i] = cards[i];
				tempCardHolder2[i] = cards[26 + i];
			}
			
			int holder1Index = 0;
			int holder2Index = 0;
			int overallIndex = 0;
			
			while (holder1Index < 26 || holder2Index < 26) {
				Card cardToMove;
				if (Math.random() < 0.5) {
					if (holder1Index < 26) {
						cardToMove = tempCardHolder1[holder1Index];
						holder1Index += 1;
					} else {
						cardToMove = tempCardHolder2[holder2Index];
						holder2Index += 1;
					}
				} else {
					if (holder2Index < 26) {
						cardToMove = tempCardHolder2[holder2Index];
						holder2Index += 1;
					} else {
						cardToMove = tempCardHolder1[holder1Index];
						holder1Index += 1;
					}
				}
				cards[overallIndex] = cardToMove;
				overallIndex += 1;
			}
		}
	}
	

	

}
