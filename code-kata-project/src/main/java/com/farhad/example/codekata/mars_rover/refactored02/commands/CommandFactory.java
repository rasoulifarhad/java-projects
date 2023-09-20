package com.farhad.example.codekata.mars_rover.refactored02.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {
    
    public static List<Command> createCommands(String message, int displacement) {
        List<Command> commands = new ArrayList<>();
        for (String commandString : parseMessage(message)) {
            commands.add(createCommand(commandString, displacement));
        }   
        return commands;
    }

    private static Command createCommand(String commandString, int displacement) {
        switch (commandString) {
            case "l":
                return new Left();
            case "r":
                return new Right();
            case "f":
                return new Forwards(displacement);
            case "b":
                return new Backwards(displacement);
            default:
                return new Identity();
        }
    }

    private static String[] parseMessage(String message) {
        return message.split("");
    }

}
