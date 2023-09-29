package com.farhad.example.bridge.standard_approach.demo1;

public class App {
 
    public static void main(String[] args) {
        TVInterface sony = new SonyTV();
        LogitechRemoteControl remoteControl = new LogitechRemoteControl(sony);
        remoteControl.setChannelKeyboard(100);
    }
}
