package com.farhad.example.design_principles02.pokemon_battle_game;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Move {

	private String name;
	private Type type;

	public String showMove() {
		return name;
		 
	}

}
