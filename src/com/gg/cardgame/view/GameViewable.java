package com.gg.cardgame.view;

import com.gg.cardgame.controller.GameController;

public interface GameViewable {
	
	public void setController(GameController controller);

    public void promptForPlayerName();

    public void showPlayerName(int playerIndex, String name);

    public void showFaceDownCardForPlayer(int playerIndex, String name);

    public void promptForFlip();

    public void showCardForPlayer(int playerIndex, String name, String rank, String suit);

    public void showWinner (String winnerName);

    public void promptForNewGame();
}
