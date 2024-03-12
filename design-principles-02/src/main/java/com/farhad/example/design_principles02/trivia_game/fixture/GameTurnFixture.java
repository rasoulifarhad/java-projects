package com.farhad.example.design_principles02.trivia_game.fixture;

import com.farhad.example.design_principles02.trivia_game.Game;

import lombok.Setter;

public class GameTurnFixture {

	@Setter
	private int roll;
	private Game theGame;

	public void execute() {
		StaticGame.theGame.takeTurn(roll);
	}
	public String player() {
		theGame = StaticGame.theGame;
		return theGame.takeTurn(roll);
	}

	public boolean gameHasStarted() {
		theGame = StaticGame.theGame;
		return theGame.gameHasStarted();
	}

}
