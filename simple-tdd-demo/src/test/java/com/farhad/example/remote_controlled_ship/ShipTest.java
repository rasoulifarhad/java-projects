package com.farhad.example.remote_controlled_ship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShipTest {

    @Test
    public void whenInstantiatedThenLocationIsSet() {
        Location location = new Location(
            new Point(21, 13), 
            Direction.NORTH);
        Ship ship = new Ship(location);
        assertEquals(location, ship.getLocation());
    }
}
