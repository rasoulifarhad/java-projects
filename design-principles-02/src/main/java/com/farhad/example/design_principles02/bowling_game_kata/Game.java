package com.farhad.example.design_principles02.bowling_game_kata;

import java.util.List;

public class Game {

		// A game has 10 frames
	private List<Frame> frames;

	// is called each time the player rolls a ball. The argument is the number of
	// pins knocked down.
	public void roll(int pins) {

	}

	// is called only at the very end of the game. It returns the total score for
	// that game.
	// the score function iterate through all the frames, and calculate all 
	// their scores.
	public int score() {
		return -1;
		// return frames.stream()
		// 			.mapToInt(Frame::score)
		// 		.sum();
	}
}
