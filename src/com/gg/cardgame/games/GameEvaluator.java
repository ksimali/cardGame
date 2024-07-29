package com.gg.cardgame.games;

import java.util.List;

import com.gg.cardgame.model.Player;
//import com.gg.cardgame.model.PlayingCard;

public interface GameEvaluator {
	public Player evaluateWinner(List<Player>players);

}
