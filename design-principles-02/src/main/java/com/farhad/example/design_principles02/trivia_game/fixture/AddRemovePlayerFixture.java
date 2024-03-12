package com.farhad.example.design_principles02.trivia_game.fixture;

import com.farhad.example.design_principles02.trivia_game.Game;
import com.farhad.example.design_principles02.trivia_game.Player;

import lombok.Setter;

public class AddRemovePlayerFixture {

	@Setter
	private String playerName;
	private Game theGame;

	public boolean addPlayer() {

		theGame = StaticGame.theGame;
		Player thePlayer =  theGame.addPlayer(playerName);
		return theGame.playerIsPlaying(thePlayer);
	}

	public int countPlayer() {
		return theGame.getNumberOfPlayers();
	}

	public boolean removePlayer() {
		theGame = StaticGame.theGame;
		Player thePlayer = theGame.getPlayerNamed(playerName);
		theGame.removePlayer(thePlayer);
		return playerWasRemoved(thePlayer);
	}

	private boolean playerWasRemoved(Player thePlayer) {
		return !theGame.playerIsPlaying(thePlayer);
	}

}
