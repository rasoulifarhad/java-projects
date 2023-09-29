package com.farhad.example.bridge.standard_approach.demo1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractRemoteControl {
    
    private TVInterface tvInterface;

    public void turnOn() {
        tvInterface.on();
    }

    public void turnOff() {
        tvInterface.off();
    }

    public void setChannel(int channel) {
        tvInterface.switchChannel(channel);
    }
}
