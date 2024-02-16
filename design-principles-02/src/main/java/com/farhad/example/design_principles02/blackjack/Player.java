package com.farhad.example.design_principles02.blackjack;

public class Player {

	private String name;
	private Hand hand;

	public Player(String name) {
		this.name = name;
		this.hand = new Hand();
	}
	
	public void receiveCard(Card card) {
		hand.addCard(card);
	}

	
}
