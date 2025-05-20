package com.farhad.example.world_of_zuul.demo02;

public class CommandWords {

    private static final String[] validCommands = { "go", "quit", "help", "look" };

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString)) {
                return true;
            }
        }
        return false;
    }

    public void showAll() {
        for (String command : validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
