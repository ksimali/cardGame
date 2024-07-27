package com.gg.cardgame.view;

import java.util.Scanner;

import com.gg.cardgame.controller.GameController;

public class CommandLineView implements GameViewable{
	
	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	
	public void setController(GameController gc) {
		this.controller = gc;
	};
	
	public void promptForPlayerName() {
		System.out.println("Entrer le nom du joueur:");
		String name = keyboard.nextLine();
		if(name.isEmpty()) {
			controller.startGame();
		}else {
			controller.addPlayer(name);
		}	
	};
	
	public void promptForFlip() {
		System.out.println("Appuyer sur entrer pour reveler les cartes");
		keyboard.nextLine();
		controller.flipCards();
		
	}
	
	public void promptForNewGame() {
		System.out.println("Appuyer sur entrer pour rejouer ou +q pour quitter");
		controller.nextAction(keyboard.nextLine());
	}
	
	public void showWinner(String playerName) {
		System.out.println("Winner is " + playerName + " !");
	}
	
	public void showPlayerName(int playerIndex, String playerName) {
		System.out.println("["+playerIndex+"]["+playerName+"]");
	}
	
	public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
		System.out.println("["+playerIndex+"]["+playerName+"][X][X]");
	}
	
	public void showCardForPlayer(int i, String playerName, String rank, String suit) {
		System.out.println("["+i+"]["+playerName+"]["+rank+"]["+suit+"]");
	}
}
