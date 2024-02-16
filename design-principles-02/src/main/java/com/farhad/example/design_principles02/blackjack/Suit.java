package com.farhad.example.design_principles02.blackjack;

public enum Suit {

	Spades("Spades"), Hearts("Hearts"), Clubs("Clubs"), Diamonds("Diamonds");

	private String name;

	Suit(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
