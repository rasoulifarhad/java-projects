package com.farhad.example.design_principles02.pokemon_battle_game;

import java.util.List;

public class Pokemon {

	private String name;
	private float weight;
	private List<Type> types;
	private List<Move> moves;

	public String showName() {
		return name;
	}

	public float showWeight() {
		return weight;
	}

	public void attack() {

	}

	public Pokemon evolve(String evolutionName) {
		return null;
	} 
}
