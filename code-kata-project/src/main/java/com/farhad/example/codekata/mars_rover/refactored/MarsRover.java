package com.farhad.example.codekata.mars_rover.refactored;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class MarsRover {
    
    private static final int MOVEMENT_DELTA = 1;

    private Coordinates coordinates;
    private Direction direction;
    
    public MarsRover(int x, int y, String direction) {
        this.coordinates = new Coordinates(x, y);
        this.direction = Direction.parse(direction);
    }

    public void receive(String commandsSequence) {
        
        for (String command : commandsSequence.split("")) {
            executeCommand(command);
        }   
    }

    private void executeCommand(String command) {
        if(command.equals("r")) {
            direction = direction.turnRight();
        } else if(command.equals("l")) {
            direction = direction.turnLeft();
        } else if(command.equals("f")) {
            coordinates = direction.moveForward(coordinates, MOVEMENT_DELTA);
        } else  if (command.equals("b")) {
            coordinates = direction.moveBackwards(coordinates, MOVEMENT_DELTA);
        }
    }

    
}
