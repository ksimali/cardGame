package com.gg.cardgame.model;

public class Player {
	private String name;
	private Hand hand;

	//getter
	public String getName() {
		return name;
	}
	
	//constructor
	public Player(String name) {
		super();
		this.name = name;
		hand = new Hand();
	}
	
	//methods
	public void addCardToHand(PlayingCard pc) {
		hand.addCard(pc);
	}
	
	public PlayingCard getCard(int index) {
		return hand.getCard(index);
	}
	
	public PlayingCard removeCard() {
		return hand.removeCard();
	}

	
}
