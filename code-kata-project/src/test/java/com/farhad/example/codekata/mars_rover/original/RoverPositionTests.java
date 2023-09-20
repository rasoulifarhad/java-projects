package com.farhad.example.codekata.mars_rover.original;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoverPositionTests {

    @Test
    public void facingNorthMoveForward() {
        Rover rover = new Rover("N", 0, 0);
        rover.receive("f");

        assertThat(rover).isEqualTo(new Rover("N", 0, 1));
    }

    @Test
    public void facingNorthMoveBackward() {
        Rover rover = new Rover("N", 0, 0);
        rover.receive("b");

        assertThat(rover).isEqualTo(new Rover("N", 0, -1));
    }

    @Test
    public void facingSouthMoveForward() {
        Rover rover = new Rover("S", 0, 0);
        rover.receive("f");

        assertThat(rover).isEqualTo(new Rover("S", 0, -1));
    }

    @Test
    public void facingSouthMoveBackward() {
        Rover rover = new Rover("S", 0, 0);
        rover.receive("b");

        assertThat(rover).isEqualTo(new Rover("S", 0, 1));
    }

    @Test
    public void facingWestMoveForward() {
        Rover rover = new Rover("W", 0, 0);
        rover.receive("f");

        assertThat(rover).isEqualTo(new Rover("W", -1, 0));
    }

    @Test
    public void facingEastMoveForward() {
        Rover rover = new Rover("E", 0, 0);
        rover.receive("f");

        assertThat(rover).isEqualTo(new Rover("E", 1, 0));
    }

    @Test
    public void facingEastMoveBackward() {
        Rover rover = new Rover("E", 0, 0);
        rover.receive("b");

        assertThat(rover).isEqualTo(new Rover("E", -1, 0));
    }
}


