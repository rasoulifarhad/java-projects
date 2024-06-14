package com.farhad.example.java_tips.null_checking.demo4;

public class SimpleGreeting implements IGreeting {

    private String printableName;

    public SimpleGreeting(String printableName) {
        this.printableName = printableName;
    }

    @Override
    public String value() {
        return "Hi " + printableName + "!";
    }

}
