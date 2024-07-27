package com.gg.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import com.gg.cardgame.games.GameEvaluator;
import com.gg.cardgame.model.Deck;
import com.gg.cardgame.model.Player;
import com.gg.cardgame.model.PlayingCard;
import com.gg.cardgame.view.CommandLineView;
import com.gg.cardgame.view.GameViewable;


public class GameController {
	
	// attributs
	enum GameState{
		AddingPlayers, CardsDealt, WinnerRevealed;
	}
	
	Deck deck;
	List<Player> players;
	Player winner;
	GameViewable view;
	
	GameState gameState;
	GameEvaluator evaluator;
	
	// constructor
	public GameController(Deck deck, GameViewable view, GameEvaluator evaluator){
		super();
		this.deck = deck;
		this.view = view;
		this.players = new ArrayList<Player>();
		this.gameState = GameState.AddingPlayers;
		this.evaluator = evaluator;
		view.setController(this);
		
	}
	
	// method run() qui regarde l'état du jeu et affiche une vue
	public void run() {
		
		while(gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}
		
		switch(gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		}
	}
	
	// method pour definir(ajouter) des joueurs
	public void addPlayer(String playerName) {
		if(gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
			}
	}
	
	// method pour demarrer le jeu
	public void startGame() {
		if(gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for(Player player : players) {
				player.addCardToHand(deck.removeTopCard());
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
		this.run();
	}
	
	// montrer les cartes
	public void flipCards() {
		int playerIndex = 1;
		for(Player player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(),
					pc.getRank().toString(), pc.getSuit().toString());
		}
		
		// calculer le gagnant
		evaluateWinner();
		// afficher le gagnant 
		displayWinner();
		// reconstruire le jeu
		rebuildDeck();
		// passer a l'étape suivante en rappelant la method run()
		gameState = GameState.WinnerRevealed;
		this.run();
	}
	
	// implementation autres methods
	
	void evaluateWinner() {
		winner = evaluator.evaluateWinner(players); // call GameEvaluator class
	}
	
	void displayWinner() {
		view.showWinner(winner.getName());
	}
	
	void rebuildDeck() {
		for(Player player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
	// function to exit the game
	void exitGame() {
		System.exit(0);
	}

	public void nextAction(String nextChoice) {
		if("+q".equals(nextChoice)) {
			exitGame();
		}else {
			startGame();
		}
		
	}
	
}
