package com.gg.cardgame.games;

import com.gg.cardgame.controller.GameController;
import com.gg.cardgame.model.Deck;
//import com.gg.cardgame.view.CommandLineView;
import com.gg.cardgame.view.GameSwingView;

public class Games {

	public static void main(String[] args) {
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		//GameController gc = new GameController(new Deck(), new CommandLineView(), new HighCardGameEvaluator());
		//GameController gc = new GameController(new Deck(), new View(), new LowCardGameEvaluator());
		GameController gc = new GameController(new Deck(), gsv, new HighCardGameEvaluator());
		
		gc.run();

	}

}
