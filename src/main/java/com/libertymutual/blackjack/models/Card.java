package com.libertymutual.blackjack.models;

public interface Card {
	
	String getSuite();

	String getVisualRepresentation();

	int[] getValues();

}
