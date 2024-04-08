package com.farhad.example.design_principles02.bowling_game_kata;

import java.util.List;

// A game has 10 frames
public class Frame {

	//A frame has 1 or two rolls
	private List<Roll> rolls;
	private Frame nextFrame;

	// The score for a spare or strike depends on the frame's successor. 
	public int score() {
		return 0;
	}
}
