package com.farhad.example.tic_tac_toe_v2.mongo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeCollectionSpecTest {

    private TicTacToeCollection collection;

    @BeforeEach
    public void setup() {
        collection = new TicTacToeCollection();
    }

    @Test
    public void whenInstantiatedThenMongoHasDbNameTicTacToe() {
        assertEquals("tic-tac-toe", 
                        collection
                            .getMongoCollection()
                                .getDBCollection()
                                    .getDB()
                                        .getName());
    }


    @Test
    public void whenInstantiatedThenMongoCollectionHasNameGame() {
        assertEquals("game", 
                        collection
                            .getMongoCollection()
                                .getName());
    }

}
