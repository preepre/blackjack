package com.libertymutual.blackjack.models;

public class AceCard implements Card {

	private String suite;
	
	public AceCard(String suite) {
		this.suite = suite;
	}
	
	@Override
	public String toString() {
		return this.getVisualRepresentation() + " of " + this.getSuite();
	}
	
	@Override
	public String getSuite() {
		return suite;
	}
	
	@Override
	public String getVisualRepresentation() {
		return "Ace";
	}
	
	@Override
	public int[] getValues() {
		return new int[] {1, 11};
	}
	
	
}
