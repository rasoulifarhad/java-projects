package com.farhad.example.codekata.mars_rover.refactored02;

import static com.farhad.example.codekata.mars_rover.refactored02.commands.CommandFactory.createCommands;

import java.util.List;

import com.farhad.example.codekata.mars_rover.refactored02.commands.Command;
import com.farhad.example.codekata.mars_rover.refactored02.movement.Vector;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class MarsRover {
    
    private static final int DISPLACEMENT = 1;

    private Vector vector;
    
    public MarsRover(int x, int y, String direction) {
        this.vector = Vector.create(x, y, direction);
    }

    public void receive(String commandsSequence) {
        execute(createCommands(commandsSequence, DISPLACEMENT));
    }

    private void execute(List<Command> commands) {
        commands.forEach(command -> {
            vector = command.execute(vector);
        });
    }

}
