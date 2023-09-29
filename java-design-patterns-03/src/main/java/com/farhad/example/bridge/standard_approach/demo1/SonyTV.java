package com.farhad.example.bridge.standard_approach.demo1;

public class SonyTV implements TVInterface {

    @Override
    public void off() {
        System.out.println("Sony is turned off.");    
    }

    @Override
    public void on() {
        System.out.println("Sony is turned on.");    
    }

    @Override
    public void switchChannel(int channel) {
        System.out.println("Sony: channel - " + channel);    
    }
    
}
