package com.gg.cardgame.model;

public class PlayingCard {

	private Rank rank;
	private Suit suit;
	private boolean faceUp;
	
	//constructor
	public PlayingCard(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	
	// getters
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}
	
}
