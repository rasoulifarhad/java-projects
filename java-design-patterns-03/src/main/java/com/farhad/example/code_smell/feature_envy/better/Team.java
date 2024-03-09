package com.farhad.example.code_smell.feature_envy.better;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Team {

	private final List<Player> players;

	public int calculateTotalGoals() {
		return StatisticsCalculator.calculateTotalGoals(players);
	}
}
