package com.farhad.example.codekata.mars_rover.refactored02.commands;

import com.farhad.example.codekata.mars_rover.refactored02.movement.Vector;

import lombok.Value;

@Value
public class Backwards implements Command{
    
    private final int delta;

    @Override
    public Vector execute(Vector vector) {
        return vector.moveBackwards(delta);
    }

}
