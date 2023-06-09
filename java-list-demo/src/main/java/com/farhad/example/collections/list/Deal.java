package com.farhad.example.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Deal {
    

    public static void main(String[] args) {
        String [] suit = new String[] { "spades", "hearts", "diamonds", "clubs" };
        String [] rank = new String[] {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
        List<String> deck = new ArrayList<>();
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck.add(rank[j] + " of " + suit[i]);
            }
        }
        Collections.shuffle(deck);

        // numberOfHands * cardsPerHand must less than or equal deck.size()
        int numberOfHands = 4;
        int cardsPerHand  = 5;
        for (int i = 0; i < numberOfHands; i++) {
            log.info( "Cards in Hand#{}: {}", i, dealHand(deck, cardsPerHand) );
        }
    }

    public static <E> List<E> dealHand(List<E> deck, int count) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - count, deckSize);
        List<E> hand = new ArrayList<>(handView);
        handView.clear();
        return hand;
    }

}
