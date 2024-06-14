package com.farhad.example.java_tips.null_checking.demo4;

public class SimpleGreeting implements IGreeting {

    private String name;

    public SimpleGreeting(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name.trim().isEmpty() ? "Hi!" : "Hi " + name + "!";
    }

}
