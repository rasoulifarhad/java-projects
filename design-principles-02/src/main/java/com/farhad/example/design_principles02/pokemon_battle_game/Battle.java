package com.farhad.example.design_principles02.pokemon_battle_game;

public class Battle {

	private int durationInMinutes;

	public int showDurationInMinutes() {
		return durationInMinutes;
	}

	public void startBattle(Trainer trainerA, Trainer trainerB) {
		System.out.println("battle between " + trainerA + " & " + trainerB + " started!");
	}
	
	public void endBattle(Trainer trainerA, Trainer trainerB) {
		System.out.println("battle between " + trainerA + " & " + trainerB + " ended!");
	}
}
