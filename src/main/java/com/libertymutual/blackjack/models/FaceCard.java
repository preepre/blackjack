package com.libertymutual.blackjack.models;

public class FaceCard implements Card {

	private String visualRepresentation;
	private String suite;

	public FaceCard(String visualRepresentation, String suite) {
		this.suite = suite;
		this.visualRepresentation = visualRepresentation;
	}

	@Override
	public String toString() {
		return this.getVisualRepresentation() + " of " + this.getSuite();
	}

	public String getVisualRepresentation() {
		return visualRepresentation;
	}

	public String getSuite() {
		return suite;
	}

	public int[] getValues() {
		return new int[] { 10, 10 };
	}

}
