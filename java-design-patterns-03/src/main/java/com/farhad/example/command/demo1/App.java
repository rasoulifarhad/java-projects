package com.farhad.example.command.demo1;


public class App {
    
    public static void main(String[] args) {
        

        Light light = new Light();
        Command lightOn = new LightsOnCommand(light);
        Command lightOff = new LightsOffCommand(light);

        RemoteControl control1 = new RemoteControl();
        control1.setCommand(lightOn);
        control1.press();

        RemoteControl control2 = new RemoteControl();
        control2.setCommand(lightOff);
        control2.press();

    }

}
