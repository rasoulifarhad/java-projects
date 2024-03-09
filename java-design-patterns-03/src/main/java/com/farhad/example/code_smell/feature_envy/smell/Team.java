package com.farhad.example.code_smell.feature_envy.smell;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Team {

	private final List<Player> players;

	public int calculateTotalGoals() {
		int totalGoals = 0;
		for (Player player : players) {
			totalGoals += player.getGoalsScored();
		}

		return totalGoals;
	}
}
