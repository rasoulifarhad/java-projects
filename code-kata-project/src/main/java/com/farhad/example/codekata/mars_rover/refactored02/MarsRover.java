package com.farhad.example.codekata.mars_rover.refactored02;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.codekata.mars_rover.refactored02.commands.Backwards;
import com.farhad.example.codekata.mars_rover.refactored02.commands.Command;
import com.farhad.example.codekata.mars_rover.refactored02.commands.Forwards;
import com.farhad.example.codekata.mars_rover.refactored02.commands.Identity;
import com.farhad.example.codekata.mars_rover.refactored02.commands.Left;
import com.farhad.example.codekata.mars_rover.refactored02.commands.Right;
import com.farhad.example.codekata.mars_rover.refactored02.movement.Vector;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class MarsRover {
    
    private static final int MOVEMENT_DELTA = 1;

    private Vector vector;
    
    public MarsRover(int x, int y, String direction) {
        this.vector = Vector.create(x, y, direction);
    }

    public void receive(String commandsSequence) {
        execute(createCommands(commandsSequence));
    }

    private void execute(List<Command> commands) {
        commands.forEach(command -> {
            vector = command.execute(vector);
        });
    }

    private List<Command> createCommands(String message) {
        List<Command> commands = new ArrayList<>();
        for (String commandString : message.split("")) {
            switch (commandString) {
                case "l":
                    commands.add(new Left());
                    break;
                case "r":
                    commands.add(new Right());
                    break;
                case "f":
                    commands.add(new Forwards(MOVEMENT_DELTA));
                    break;
                case "b":
                    commands.add(new Backwards(MOVEMENT_DELTA));
                    break;
                default:
                    commands.add(new Identity());
                    break;
            }
        }   
        return commands;
    }
}
