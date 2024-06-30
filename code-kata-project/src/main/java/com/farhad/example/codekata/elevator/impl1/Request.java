package com.farhad.example.codekata.elevator.impl1;

import lombok.Value;

@Value
public class Request {

    private int currentFloor;
    private int desiredFloor;
    private Direction direction;
    private Location location;
}
