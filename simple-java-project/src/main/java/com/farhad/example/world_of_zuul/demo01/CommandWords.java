package com.farhad.example.world_of_zuul.demo01;

public class CommandWords {

    private static final String[] validCommands = { "go", "quit", "help" };

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString)) {
                return true;
            }
        }
        return false;
    }
}
