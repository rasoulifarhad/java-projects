package com.farhad.example.codekata.mars_rover.refactored;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Coordinates {

    private final int x;
    private final int y;

    public Coordinates incrementX(int delta) {
        return new Coordinates(x + delta, y);
    }

    public Coordinates incrementY(int delta) {
        return new Coordinates(x, y + delta);
    }

}
