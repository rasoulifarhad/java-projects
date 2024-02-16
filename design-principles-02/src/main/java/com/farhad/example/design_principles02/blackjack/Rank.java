package com.farhad.example.design_principles02.blackjack;

import lombok.Getter;

public enum Rank {

	Two("Two", 2),
	Three("Three",3),
	Four("Four", 4),
	Five("Five",5),
	Six("Six", 6),
	Seven("Seven", 7),
	Eight("Eight", 8),
	Nine("Nine", 9),
	Jack("Jack", 10),
	Queen("Queen", 10),
	King("King", 10),
	Ace("Ace", 11),;

	private String name;

	@Getter
	private int value;

	Rank(String name, int value) {
		this.name = name;
		this.value = value;
	}

	
	public String toString() {
		return name;
	}
}
