package com.farhad.example.activeobject;

import java.util.LinkedList;
import java.util.List;

public class ActiveObjectEngine {
    
    List<? super Command> itsCommands  = new LinkedList<>();

    public void addCommand(Command command) {
        itsCommands.add(command);
    }

    public void run() throws Exception {
        while (!itsCommands.isEmpty()) {
            Command c = (Command)itsCommands.get(0);
            itsCommands.remove(0);
            c.execute();
        }
    }
}
