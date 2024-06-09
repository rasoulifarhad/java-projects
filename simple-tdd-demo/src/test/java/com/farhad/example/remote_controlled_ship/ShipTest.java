package com.farhad.example.remote_controlled_ship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShipTest {

    private Ship ship;
    private Location location;

    @BeforeEach
    public void setup() {

        location = new Location(new Point(21, 13), Direction.NORTH);
        ship = new Ship(location);
    }

    @Test
    public void whenInstantiatedThenLocationIsSet() {
        assertEquals(location, ship.getLocation());
    }

    // @Test
    // public void givenNorthWhenMoveForwardThenYDecreases() {
    //     ship.moveForward();
    //     assertEquals(12, ship.getLocation().getPoint().getY());
    // }
     
    // @Test
    // public void givenEastWhenMoveForwardThenXIncrease() {
    //     ship.getLocation().setDirection(Direction.EAST);
    //     ship.moveForward();
    //     assertEquals(22, ship.getLocation().getPoint().getX());
    // }

    @Test
    public void whenMoveForwardThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(expected, ship.getLocation());
    }

    @Test
    public void whenMoveBackwardThenBackward() {
        Location expected = location.copy();
        expected.backward();
        ship.moveBackward();
        assertEquals(expected, ship.getLocation());
    }

    @Test
    public void whenTurnLeftThenLeft() {
        Location expected = location.copy();
        expected.turnLeft();;
        ship.turnLeft();
        assertEquals(expected, ship.getLocation());
    }
    
    @Test
    public void whenTurnRightThenRight() {
        Location expected = location.copy();
        expected.turnRight();
        ship.turnRight();
        assertEquals(expected, ship.getLocation());
    }    

    @Test
    public void whenReceivedCommandsFThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.receiveCommands("f");
        assertEquals(expected, ship.getLocation());
    }

    @Test
    public void whenReceivedCommandsBThenBackward() {
        Location expected = location.copy();
        expected.backward();
        ship.receiveCommands("b");
        assertEquals(expected, ship.getLocation());
    }

    @Test
    public void whenReceivedCommandsLThenTurnLeft() {
        Location expected = location.copy();
        expected.turnLeft();
        ship.receiveCommands("l");
        assertEquals(expected, ship.getLocation());
    }

    @Test
    public void whenReceivedCommandsRThenTurnRight() {
        Location expected = location.copy();
        expected.turnRight();
        ship.receiveCommands("r");
        assertEquals(expected, ship.getLocation());
    }

    @Test
    public void whenReceiveCommandsThenAllAreExecuted() {
        Location expected = location.copy();
        expected.turnRight();
        expected.forward();
        expected.turnLeft();
        expected.backward();
        ship.receiveCommands("rflb");
        assertEquals(expected, ship.getLocation());
    }

}
