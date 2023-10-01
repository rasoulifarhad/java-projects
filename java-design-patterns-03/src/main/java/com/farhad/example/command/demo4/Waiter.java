package com.farhad.example.command.demo4;

public class Waiter extends Invoker {

    @Override
    public void invokeCommand() {
       getCommand().execute() ;
    }

    public void takeOrder(){
        invokeCommand();
    }
    
    public void serveOrder(){
        invokeCommand();
    }
}
