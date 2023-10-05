package com.farhad.example.hunt_the_wumpus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WumpusGameTest {

    // This function creates a new WumpusGame , connects room 4 to room 5 via an east 
    // passage, places the player in room 4, issues the command to move east, and then 
    // asserts that the player should be in room 5.
    //
    // You state your intent in a test before you implement it, making your intent as simple 
    // and readable as possible. You trust that this simplicity and clarity points to a good 
    // structure for the program.
    @Test
    void testMove() {
        WumpusGame g = new WumpusGame();
        // connects room 4 to room 5 via an east passage
        g.connect(4, 5, "E");
        // places the player in room 4
        g.setPlayerRoom(4);
        // issues the command to move east
        g.east();
        // asserts that the player should be in room 5
        assertEquals(5, g.playerRoom());
    }
}
