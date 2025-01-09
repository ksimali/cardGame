package com.oc.cardgame.view;

import java.util.Scanner;

import com.oc.cardgame.controller.GameController;

public class CommandLineView implements GameViewable{
	
	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	
	public void setController(GameController gc) {
		this.controller = gc;
	}
	
	// Method pour ajouter des joueurs
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
		System.out.println("Appuyer sur Entrer pour montrer les cartes");
		keyboard.nextLine();
		controller.flipCards();
	};
	
	public void promptForNewGame() {
		System.out.println("Appuyer sur Entrer pour rejouer ou +q pour quitter");
		//keyboard.nextLine();
		controller.nextAction(keyboard.nextLine());
	};
	
	public void showWinner(String playerName) {
		System.out.println("Le gagnant est " + playerName + " !");
	}
	
	public void showPlayerName(int playerIndex, String playerName) {
		System.out.println("[" +playerIndex+"]["+playerName+"]");
	};
	
	public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
		System.out.println("[" +playerIndex+"]["+playerName+"][x][x]");
	};
	
	public void showCardForPlayer(int playerIndex, String playerName,
			String rank, String suit) {
		System.out.println("["+playerIndex+"]["+playerName+"]["+rank+"]["+suit+"]");
	};
}
