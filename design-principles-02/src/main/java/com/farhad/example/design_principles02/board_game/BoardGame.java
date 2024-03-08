package com.farhad.example.design_principles02.board_game;

public abstract class BoardGame {

	GamePiece currentPlayer;

	public void play() {
		while (!finished()) {
			currentPlayer.move();
			currentPlayer = nextPlayer();
		}
	}

	protected abstract boolean finished();

	protected abstract GamePiece nextPlayer();
}