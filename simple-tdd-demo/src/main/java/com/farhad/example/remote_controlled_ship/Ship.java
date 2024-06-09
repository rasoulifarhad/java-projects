package com.farhad.example.remote_controlled_ship;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Ship {

    private final Location location;

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

    public void receiveCommands(String command) {
        switch (command.charAt(0)) {
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
        
            default:
                break;
        }
    }


}
