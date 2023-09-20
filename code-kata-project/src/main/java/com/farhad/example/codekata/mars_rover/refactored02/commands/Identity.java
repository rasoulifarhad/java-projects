package com.farhad.example.codekata.mars_rover.refactored02.commands;

import com.farhad.example.codekata.mars_rover.refactored02.movement.Vector;

public class Identity implements Command {

    @Override
    public Vector execute(Vector vector) {
        return vector;
    }
    
}
