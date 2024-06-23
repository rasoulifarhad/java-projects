package com.farhad.example.tic_tac_toe_v2.mongo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeBeanTest {


    private TicTacToeBean bean;
    private final int turn = 10;
    private final int x = 2;
    private final int y = 3 ;
    private final char player = 'X';

    @BeforeEach
    public void setup() {
        bean = new TicTacToeBean(turn, x, y, player);
    }

    @Test
    public void whenInstantiatedThenTurnStored() {
        assertEquals(turn, bean.getTurn());
    }

    @Test
    public void whenInstantiatedThenXStored() {
        assertEquals(x, bean.getX());
    }

    @Test
    public void whenInstantiatedThenYStored() {
        assertEquals(y, bean.getY());
    }

    @Test
    public void whenInstantiatedThenPlayerStored() {
        assertEquals(player, bean.getPlayer());
    }
}
