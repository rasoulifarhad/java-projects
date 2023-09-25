package com.farhad.example.hunt_the_wumpus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest {

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
        assertEquals(5, g.getPlayerRoom());
    }
}
