package com.farhad.example.codekata.mars_rover.original;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RoverReceivingCommandsListTests {

    @Test
    public void noCommands() {
        Rover rover = new Rover("N", 0, 0);

        rover.receive("");

        assertEquals(new Rover("N", 0, 0), rover);
    }

    @Test
    public void twoCommands() {
        Rover rover = new Rover("N", 0, 0);

        rover.receive("lf");

        assertEquals(new Rover("W", -1, 0), rover);
    }

    @Test
    public void manyCommands() {
        Rover rover = new Rover("N", 0, 0);

        rover.receive("ffrbbrfflff");

        assertEquals(new Rover("E", 0, 0), rover);
    }    
}


