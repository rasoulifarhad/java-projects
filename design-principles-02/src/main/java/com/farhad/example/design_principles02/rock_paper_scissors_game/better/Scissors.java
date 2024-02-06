package com.farhad.example.design_principles02.rock_paper_scissors_game.better;

public class Scissors implements GameObject {

	@Override
	public boolean beats(GameObject gameObject) {
		return gameObject.beatsScissors();
	}

	@Override
	public boolean beatsRock() {
		return false;
	}

	@Override
	public boolean beatsPaper() {
		return true;
	}

	@Override
	public boolean beatsScissors() {
		return false;
	}

}
