package com.farhad.example.remote_controlled_ship;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ship {

    private Location location;
    private Planet planet;

    public boolean moveForward() {
        return location.forward(planet.getMax(), planet.getObstacles());
    }

    public boolean moveBackward() {
        return location.backward(planet.getMax(), planet.getObstacles());
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public String receiveCommands(String commands) {
        StringBuilder output = new StringBuilder();
        for (char command : commands.toCharArray()) {
            output.append(receiveCommand(command));
        }
        return output.toString();
    }

    private String receiveCommand(char command) {
        boolean status = true;
        switch (command) {
            case 'f':
                status = moveForward();
                break;
            case 'b':
            status = moveBackward();
                break;
            case 'l':
                turnLeft();;
                break;
            case 'r':
                turnRight();;
                break;
        }
        if (status) {
            return "O";
        } else {
            return "X";
        }
    }

    public Planet getPlanet() {
        return planet;
    }


}
