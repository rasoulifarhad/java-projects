package com.farhad.example.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Tic-tac-toe is a paper-and-pencil game for two players, X and O,
// who take turns marking the spaces in a 3×3 grid. The player who
// succeeds in placing three respective marks in a horizontal, vertical,
// or diagonal row, wins the game.
public class TicTacToeTest {

    private TicTacToe ticTacToe;


    @BeforeEach 
    public void setup() {
        ticTacToe = new TicTacToe();
    }


    @Test
    void whenXOutsideBoardThenRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(5, 2);
        });
        
    }

    @Test
    void whenYOutsideBoardThenRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(5, 5);
        });
        
    }

    @Test
    void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(2, 1);
        });
        
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX() {
        assertEquals('X', ticTacToe.nextPlayer());
    }
}
