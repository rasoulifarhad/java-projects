package com.farhad.example.design_principles02.blackjack;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Card {

	private final Suit suit;
	private final Rank rank;

	public String toString() {
		return ("[" + rank + " of " + suit + "] (" + rank.getValue() + ")");
	}
}
