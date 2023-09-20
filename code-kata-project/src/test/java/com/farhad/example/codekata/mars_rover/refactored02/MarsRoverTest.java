package com.farhad.example.codekata.mars_rover.refactored02;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

public class MarsRoverTest {

    @Test
    public void dose_nothing_when_receiving_empty_commands_sequence() {
        //given
        MarsRover rover = new MarsRover(0, 0, "N");
        //when
        rover.receive("");
        //then
        assertThat(rover, is(new MarsRover(0, 0, "N")));
    }

    @Test
    public void turns_right_when_pointing_north() {
        //given
        MarsRover rover = new MarsRover(0, 0, "N");
        //when
        rover.receive("r");
        //then
        assertThat(rover, is(new MarsRover(0, 0, "E")));
    }

    @Test
    public void turns_right_when_pointing_east() {
        //given
        MarsRover rover = new MarsRover(0, 0, "E");
        //when
        rover.receive("r");
        //then
        assertThat(rover, is(new MarsRover(0, 0, "S")));
    }

    @Test
    public void turns_right_when_pointing_south() {
        //given
        MarsRover rover = new MarsRover(0, 0, "S");
        //when
        rover.receive("r");
        //then
        assertThat(rover, is(new MarsRover(0, 0, "W")));
    }

    @Test
    public void turns_right_when_pointing_west() {
        //given
        MarsRover rover = new MarsRover(0, 0, "W");
        //when
        rover.receive("r");
        //then
        assertThat(rover, is(new MarsRover(0, 0, "N")));
    }

    @Test
    public void turns_left_when_pointing_west() {
        //given
        MarsRover rover = new MarsRover(0, 0, "W");
        //when
        rover.receive("l");
        //then
        assertThat(rover, is(new MarsRover(0, 0, "S")));
    }

    @Test
    public void moves_forward_when_pointing_south() {
        MarsRover marsRover = new MarsRover(5, 4, "S");

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(5, 3, "S")));
    } 
    
    @Test
    public void moves_backward_when_pointing_north() {
        MarsRover marsRover = new MarsRover(5, 4, "N");

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(5, 3, "N")));
    }

    @Test
    public void moves_backward_when_pointing_east() {
        MarsRover marsRover = new MarsRover(5, 4, "E");

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(4, 4, "E")));
    }

    @Test
    public void moves_backward_when_pointing_south() {
        MarsRover marsRover = new MarsRover(5, 4, "S");

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(5, 5, "S")));
    }

    @Test
    public void moves_backward_when_pointing_west() {
        MarsRover marsRover = new MarsRover(5, 4, "W");

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(6, 4, "W")));
    }

    @Test
    public void receives_multiple_commands() {
        MarsRover marsRover = new MarsRover(7, 4, "E");

        marsRover.receive("fr");

        assertThat(marsRover, is(new MarsRover(8, 4, "S")));
    }

    @Test
    public void ignores_unknown_commands() {
        MarsRover marsRover = new MarsRover(7, 4, "E");

        marsRover.receive("*");

        assertThat(marsRover, is(new MarsRover(7, 4, "E")));
    }    
}
