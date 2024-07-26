package com.gg.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<PlayingCard> cards;
	
	// creation des 52 cartes
	public Deck() {
		cards = new ArrayList<PlayingCard>();
		for(Rank rank : Rank.values()) {
			for(Suit suit: Suit.values()) {
				System.out.println("Creating card ["+rank+"]["+suit+"]");
				cards.add(new PlayingCard(rank, suit));
			}
		}
		
		shuffle(); // melanger les cartes
	}
	
	// method shuffle()
	public void  shuffle() {
		Random random = new Random();
		for(int i = 0; i < cards.size(); i++) {
			Collections.swap(cards, i, random.nextInt(cards.size()));
		}
	}
	
	// method pour tirer la carte dans le pacquet et remettre la carte également.
	
	public PlayingCard removeTopCard() {
		return cards.remove(0);
	}
	
	public void returnCardToDeck(PlayingCard pc) {
		cards.add(pc);
	}
	
	public List<PlayingCard> getCards(){
		return cards;
	}
	
	

}
