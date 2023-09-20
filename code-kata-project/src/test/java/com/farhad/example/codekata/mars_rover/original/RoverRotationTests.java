package com.farhad.example.codekata.mars_rover.original;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoverRotationTests {

    @Test
    public void facingNorthRotateLeft() { 
        Rover rover = new Rover("N", 0, 0);

        rover.receive("l");

        Assertions.assertThat(rover).isEqualTo(new Rover("W", 0, 0));
    }

    @Test
    public void facingNorthRotateRight() {
        Rover rover = new Rover("N", 0, 0);

        rover.receive("r");

        assertEquals(new Rover("E", 0, 0), rover);
    }

    @Test
    public void facingSouthRotateLeft() {
        Rover rover = new Rover("S", 0, 0);

        rover.receive("l");

        assertEquals(new Rover("E", 0, 0), rover);
    }

    @Test
    public void facingSouthRotateRight() {
        Rover rover = new Rover("S", 0, 0);

        rover.receive("r");

        assertEquals(new Rover("W", 0, 0), rover);
    }

    @Test
    public void facingWestRotateLeft() {
        Rover rover = new Rover("W", 0, 0);

        rover.receive("l");

        assertEquals(new Rover("S", 0, 0), rover);
    }

    @Test
    public void facingWestRotateRight() {
        Rover rover = new Rover("W", 0, 0);

        rover.receive("r");

        assertEquals(new Rover("N", 0, 0), rover);
    }

    @Test
    public void facingEastRotateLeft() {
        Rover rover = new Rover("E", 0, 0);

        rover.receive("l");

        assertEquals(new Rover("N", 0, 0), rover);
    }

    @Test
    public void facingEastRotateRight() {
        Rover rover = new Rover("E", 0, 0);

        rover.receive("r");

        assertEquals(new Rover("S", 0, 0), rover);
    }    
}
