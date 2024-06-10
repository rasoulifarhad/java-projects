package com.farhad.example.remote_controlled_ship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShipTest {

    private Ship ship;
    private Location location;
    private Planet planet;

    @BeforeEach
    public void setup() {

        Point max = new Point(50, 50);
        location = new Location(new Point(21, 13), Direction.NORTH);
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(44, 44));
        obstacles.add(new Point(45, 46));        
        planet = new Planet(max, obstacles);
        ship = new Ship(location, planet);
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

    @Test
    public void whenInstantiatedThenPlanetIsStored() {
        assertEquals(planet, ship.getPlanet());
    }

    @Test
    public void givenDirectionEAndXEqualsMaxXWhenReceiveCommandsFThenWrap() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        ship.receiveCommands("f");
        assertEquals(1, location.getX());
    }

    @Test
    public void whenReceiveCommandsThenStopOnObstacle() {
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(location.getX() + 1, location.getY()));
        ship.getPlanet().setObstacles(obstacles);
        Location expected = location.copy();
        expected.turnRight();
        expected.turnLeft();
        expected.backward(new Point(0, 0), new ArrayList<>());
        ship.receiveCommands("rflb");
        assertEquals(expected, ship.getLocation());
    }

    @Test
    public void whenReceiveCommandsThenOForOkAndXForObstacle() {
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(location.getX() + 1, location.getY()));
        ship.getPlanet().setObstacles(obstacles);
        String status = ship.receiveCommands("rflb");
        assertEquals(status, "OXOO");
    }
}
