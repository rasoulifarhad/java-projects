package com.farhad.example.design_principles02.rock_paper_scissors_game.better;

public class Rock implements GameObject {

	@Override
	public boolean beats(GameObject gameObject) {
		return gameObject.beatsRock();
	}

	@Override
	public boolean beatsRock() {
		return false;
	}

	@Override
	public boolean beatsPaper() {
		return false;
	}

	@Override
	public boolean beatsScissors() {
		return true;
	}

}
