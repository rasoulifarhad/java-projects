package com.farhad.example.design_principles02.pokemon_battle_game;

import java.util.List;

public class Team {

	private int id;
	private int battlesWon;
	private int battelsLost;
	private List<Pokemon> pokemons;

	public int showId() {
		return id;
	}

	public void updateBattlesWon() {
		battlesWon++;
	}

	public void updateBattlesLost() {
		battelsLost++;
	}

	public int showBattlesWon() {
		return battlesWon;
	}

	public int showBattlesLost() {
		return battelsLost;
	}

}
