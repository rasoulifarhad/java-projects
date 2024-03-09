package com.farhad.example.code_smell.feature_envy.better;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Player> players = new ArrayList<>();

		players.add(new Player("player #1", 10));
		players.add(new Player("player #3", 15));
		players.add(new Player("player #6", 8));

		Team team = new Team(players);

		int totalGoals = team.calculateTotalGoals();
		System.out.println("Total goals scored by the team: " + totalGoals);

	}
}
