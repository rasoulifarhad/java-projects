package com.farhad.example.bridge.standard_approach.demo1;

public class LogitechRemoteControl extends AbstractRemoteControl {

    public LogitechRemoteControl(TVInterface tvInterface) {
        super(tvInterface);
    }

    public void setChannelKeyboard(int channel) {
        setChannel(channel);
        System.out.println("Logitech use keyword to set channel.");
    }

    
    
}
