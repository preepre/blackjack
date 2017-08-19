package com.libertymutual.blackjack.models;

public class NumberCard implements Card{
	
	private int value;
	private String suite;
	
	public NumberCard(int value, String suite) {
		this.value = value;
		this.suite = suite;
	}
	
	@Override
	public String toString() {
		return this.getVisualRepresentation() + " of " + this.getSuite();
	}
	
	public int[] getValues() {
		return new int[] {value, value};
	}
	
	public String getSuite() {
		return suite;
	}
	
	public String getVisualRepresentation() {
		return String.valueOf(value);
	}
	

}
