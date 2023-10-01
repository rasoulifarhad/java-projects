package com.farhad.example.command.demo4;

public class Manager extends Invoker {

    @Override
    public void invokeCommand() {
       getCommand().execute() ;
    }

    public void validateOrder(){
        invokeCommand();
    }
   
}
