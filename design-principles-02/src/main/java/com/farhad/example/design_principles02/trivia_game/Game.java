package com.farhad.example.design_principles02.trivia_game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Player> players;

	

	public Game() {
		this.players = new ArrayList<>();
	}

	public int getNumberOfPlayers() {
		return players.size();
	}

	public Player addPlayer(String playerName) {
		Player player = new Player(playerName);
		players.add(player);
		return player;
	}

	public boolean playerIsPlaying(Player player) {
		return players.contains(player);
	}

	public void removePlayer(Player thePlayer) {
		players.remove(thePlayer);
	}

	public Player getPlayerNamed(String playerName) {
		return players.stream()
			.filter(p -> p.getName().equalsIgnoreCase(playerName))
			.findFirst()
				.orElse(null);
	}

	public String takeTurn(int roll) {
		return "AI";
	}

	public boolean gameHasStarted() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'gameHasStarted'");
	}

}
