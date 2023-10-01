package com.farhad.example.command.demo4;

public class Cook extends Invoker {

    @Override
    public void invokeCommand() {
       getCommand().execute() ;
    }

    public void prepareOrder(){
        invokeCommand();
    }

}
