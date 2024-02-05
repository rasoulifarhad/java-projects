package com.farhad.example.design_principles02.rock_paper_scissors_game.bad;

public class Scissors implements GameObject {

	@Override
	public boolean beats(GameObject gameObject) {
		if (gameObject.getClass().getName().equals("Rock")) {
			return false;
		} else if (gameObject.getClass().getName().equals("Paper")) {
			return true;
		} else if (gameObject.getClass().getName().equals("Scissors")) {
			return false;
		}

		return false;
	}

}
