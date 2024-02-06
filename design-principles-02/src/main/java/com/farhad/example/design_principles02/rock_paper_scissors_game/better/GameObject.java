package com.farhad.example.design_principles02.rock_paper_scissors_game.better;

public interface GameObject {

	boolean beats(GameObject gameObject);

	boolean beatsRock();

	boolean beatsPaper();

	boolean beatsScissors();
}
