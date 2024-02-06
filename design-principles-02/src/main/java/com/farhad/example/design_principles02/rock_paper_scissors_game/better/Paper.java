package com.farhad.example.design_principles02.rock_paper_scissors_game.better;

public class Paper implements GameObject {

	@Override
	public boolean beats(GameObject gameObject) {
		return gameObject.beatsPaper();
	}

	@Override
	public boolean beatsRock() {
		return true;
	}

	@Override
	public boolean beatsPaper() {
		return false;
	}

	@Override
	public boolean beatsScissors() {
		return false;
	}

}
