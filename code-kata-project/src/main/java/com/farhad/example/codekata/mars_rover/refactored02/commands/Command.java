package com.farhad.example.codekata.mars_rover.refactored02.commands;

import com.farhad.example.codekata.mars_rover.refactored02.movement.Vector;

public interface Command {
    Vector execute(Vector vector);
}
