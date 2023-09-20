package com.farhad.example.codekata.mars_rover.original;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoverEqualityTests {

    @Test
    public void equalRovers() {
        assertThat(new Rover("N", 1, 1))
                .isEqualTo(new Rover("N", 1, 1));
    }

    @Test
    public void notEqualRovers() {
        assertThat(new Rover("N", 1, 1))
                .isNotEqualTo(new Rover("S", 1, 1));

        assertThat(new Rover("N", 1, 1))
                .isNotEqualTo(new Rover("S", 2, 1));

        assertThat(new Rover("N", 1, 1))
                .isNotEqualTo(new Rover("S", 1, 0));
    }
}
