package com.gg.cardgame.games;

import com.gg.cardgame.controller.GameController;
import com.gg.cardgame.model.Deck;
import com.gg.cardgame.view.CommandLineView;

public class Games {

	public static void main(String[] args) {
		GameController gc = new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator());
		//GameController gc = new GameController(new Deck(), new View(), new LowCardGameEvaluator());
		gc.run();

	}

}
