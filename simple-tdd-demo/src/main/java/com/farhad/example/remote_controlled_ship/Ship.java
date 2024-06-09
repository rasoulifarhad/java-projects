package com.farhad.example.remote_controlled_ship;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ship {

    private Location location;
    private Planet planet;

    public boolean moveForward() {
        return location.forward();
    }

    public boolean moveBackward() {
        return location.backward();
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public void receiveCommands(String commands) {
        for (char command : commands.toCharArray()) {
            receiveCommand(command);
        }
    }

    private void receiveCommand(char command) {
        switch (command) {
            case 'f':
                location.forward();
                break;
            case 'b':
                location.backward();
                break;
            case 'l':
                location.turnLeft();
                break;
            case 'r':
                location.turnRight();
                break;
        }
    }

    public Object getPlanet() {
        return planet;
    }


}
