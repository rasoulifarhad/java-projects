package com.farhad.example.design_principles02.blackjack;

//  we need a deck of cards to play the game: Deck, Card
//
// and there is at least one gambler who plays against the dealer: Gambler, Dealer
//
// when the game is played both the gambler and the dealer have a hand of cards: Hand
//
// And those cards are dealt to them from a shoe: Shoe
//
//  all of this is happening at a table: Table
//
// Relationships:
// 
// - has many”
// - “has a”
// - “belongs to”
// - “has many through”
// 
// Blackjack game:
//
// - A Deck has many Cards
// - A Card belongs to a Deck
// - A Shoe has many Decks
// - A Table has a Shoe
// - A Deck belong to a Shoe
// - A Hand has many Cards
// - A Card (Optionally) belongs to a Hand
// - A Gambler has many Cards	
// - A hand belongs to a  Gambler or a Dealer 
// - A Gambler has many Cards through Hands
//
// - a Gambler has a Name and a bankroll
// - A Card has a Suit AND A RANK


public class App {

	public static void main(String[] args) {
		
		System.out.println("Welcome to blackjack");

		Deck testDeck = new Deck();
		testDeck.add(new Card(Suit.Clubs, Rank.Queen));
		testDeck.add(new Card(Suit.Diamonds, Rank.Ace));
		testDeck.add(new Card(Suit.Spades, Rank.Six));
		System.out.println(testDeck);

		Deck anotherTestDeck = new Deck(true);
		System.out.println(anotherTestDeck);
	}
}
