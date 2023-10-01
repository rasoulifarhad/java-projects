package com.farhad.example.command.demo1;

public class Light {
    private boolean on;
    public void switchOn() {
        System.out.println("switchOn");
        on = true;
    }

    public void switchOff() {
        System.out.println("switchOff");
        on = false;
    }

}
