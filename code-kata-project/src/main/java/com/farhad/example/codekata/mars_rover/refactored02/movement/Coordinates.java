package com.farhad.example.codekata.mars_rover.refactored02.movement;

import lombok.Value;

@Value
public class Coordinates {

    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates incrementX(int delta) {
        return new Coordinates(x + delta, y);
    }

    public Coordinates incrementY(int delta) {
        return new Coordinates(x, y + delta);
    }

}
