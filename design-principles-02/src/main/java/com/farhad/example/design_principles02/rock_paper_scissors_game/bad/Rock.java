package com.farhad.example.design_principles02.rock_paper_scissors_game.bad;

public class Rock implements GameObject{

	@Override
	public boolean beats(GameObject gameObject) {
		if (gameObject.getClass().getName().equals("Rock")) {
			return false;
		} else if(gameObject.getClass().getName().equals("Paper")) {
			return false;
		} else if (gameObject.getClass().getName().equals("Scissors")) {
			return true;
		}

		return false;
	}

}
