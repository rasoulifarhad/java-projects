package com.farhad.example.code_smell.feature_envy.better;

import java.util.List;

public class StatisticsCalculator {

	public static int calculateTotalGoals(List<Player> players) {
		return players.stream().mapToInt(Player::getGoalsScored).sum();
	}
}
