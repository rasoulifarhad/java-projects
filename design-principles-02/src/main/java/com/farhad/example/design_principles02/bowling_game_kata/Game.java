package com.farhad.example.design_principles02.bowling_game_kata;

import java.util.List;

public class Game {

	private int rolls[] = new int[21];
	private int currentRoll = 0;

	// A game has 10 frames
	private List<Frame> frames;

	// is called each time the player rolls a ball. The argument is the number of
	// pins knocked down.
	// roll() calculates score, but name dose not imply that.
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	// is called only at the very end of the game. It returns the total score for
	// that game.
	// the score function iterate through all the frames, and calculate all 
	// their scores.
	// score() dose not calculate score, but name dose not implies that it dose.
	//
	public int score() {
		int score = 0;
		int frameIndex = 0;
		for (int frame = 0; frame < 10; frame++) {
			if(isStrike(frameIndex)) { 
				score += 10 + strikeBouns(frameIndex);
				frameIndex++;
			} else if (isSpare(frameIndex)) {
				score += 10 + spareBouns(frameIndex);
				frameIndex += 2;
			} else {
				score += sumOfBallsInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score;
	}

	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}

	private int spareBouns(int frameIndex) {
		return rolls[frameIndex + 2];
	}

	private int strikeBouns(int frameIndex) {
		return rolls[frameIndex + 1] + rolls[frameIndex + 2];
	}

	private int sumOfBallsInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}

	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
	}
}
