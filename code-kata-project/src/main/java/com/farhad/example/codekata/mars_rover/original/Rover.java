package com.farhad.example.codekata.mars_rover.original;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Rover {
    
    private String direction;
    private int x;
    private int y;

    public Rover(String direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); i++) {
            String command = commandsSequence.substring(i, i+1);
            if (command.equals("l") || command.equals("r")) {

                // Rotate Rover
                if(direction.equals("N")) {
                    if(command.equals("r")) {
                        direction = "E";
                    } else {
                        direction = "W";
                    }
                } else if (direction.equals("S")) {
                    if(command.equals("r")) {
                        direction = "W";
                    } else {
                        direction = "E";
                    }

                } else if (direction.equals("W")) {
                    if(command.equals("r")) {
                        direction = "N";
                    } else {
                        direction = "S";
                    }
 
                } else {
                    if(command.equals("r")) {
                        direction = "S";
                    } else {
                        direction = "N";
                    }

                }
            } else {

                // Displace Rover
                int displacement1 = -1;
                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if(direction.equals("N")) {
                    y += displacement;
                } else if (direction.equals("S")) {
                    y -= displacement;
                } else if (direction.equals("W")) {
                    x -= displacement;
                } else {
                    x += displacement;
                }
            }
        }
    }



    public String getDirection() {
        return direction;
    }



    public int getX() {
        return x;
    }



    public int getY() {
        return y;
    }

}
