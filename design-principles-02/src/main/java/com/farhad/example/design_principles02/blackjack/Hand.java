package com.farhad.example.design_principles02.blackjack;

import java.util.List;

import lombok.Data;

@Data
public class Hand {

	List<Card> cards;

	public String toString() {
		StringBuilder sb = new StringBuilder("\nDeck:\n");
		for (Card card : cards) {
			sb.append(card).append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public void addCard(Card card) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addCard'");
	}
	
}
