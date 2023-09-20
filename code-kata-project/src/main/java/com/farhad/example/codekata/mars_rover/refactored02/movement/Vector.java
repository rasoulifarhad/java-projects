package com.farhad.example.codekata.mars_rover.refactored02.movement;

import lombok.Value;

@Value
public class Vector {
    
    private final Coordinates coordinates;
    private final Direction direction;

    private Vector(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public static Vector create(int x, int y, String direction) {
        return new Vector(
            new Coordinates(x, y), 
            Direction.parse(direction));
    }

    public Vector turnRight() {
        return new Vector(coordinates, direction.turnRight());
    }

    public Vector turnLeft() {
        return new Vector(coordinates, direction.turnLeft());
    }

    public Vector moveForwards(int delta) {
        return new Vector(direction.moveForward(coordinates, delta), direction);
    }

    public Vector moveBackwards(int delta) {
        return new Vector(direction.moveBackwards(coordinates, delta), direction);
    }

}
