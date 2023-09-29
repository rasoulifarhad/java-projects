package com.farhad.example.bridge.standard_approach.demo1;

public class SamsungTV implements TVInterface{
   
    @Override
    public void off() {
        System.out.println("Samsung is turned off.");    
    }

    @Override
    public void on() {
        System.out.println("Samsung is turned on.");    
    }

    @Override
    public void switchChannel(int channel) {
        System.out.println("Samsung: channel - " + channel);    
    }
    
}
