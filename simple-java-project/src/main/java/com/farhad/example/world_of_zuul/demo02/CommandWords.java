package com.farhad.example.world_of_zuul.demo02;

public class CommandWords {

    private static final String[] validCommands = { "go", "quit", "help", "look", "take", "drop", "items", "eat" };

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString)) {
                return true;
            }
        }
        return false;
    }

    public String getCommandList() {
        String commands = "";
        for (String command : validCommands) {
            commands += command + "  ";
        }
        return commands;

    }
}
