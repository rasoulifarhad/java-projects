package com.farhad.example.design_principles02.blackjack;

import java.util.Stack;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Deck {

	Stack<Card> cards = new Stack<>();
	// private Shoe shoe;

	public void add(Card card) {
		cards.push(card);
	}

	public Deck(boolean makeDecks) {
		if(makeDecks) {
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					cards.add(new Card(suit, rank));
				}
				
			}
		}
	}
	

	public Card draw() {
		if (cards.isEmpty()) {
			fillDeckWithAllCards();
		}
		return cards.pop();
	}
	private void fillDeckWithAllCards() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'fillDeckWithAllCards'");
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("\nDeck:\n");
		for (Card card : cards) {
			sb.append(card).append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
