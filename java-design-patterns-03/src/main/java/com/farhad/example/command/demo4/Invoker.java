package com.farhad.example.command.demo4;

import lombok.Data;

@Data
public abstract class Invoker {
     //Name of Waiter, Manager etc
    private String name;


    private Command  command;

    public abstract void invokeCommand();
}
