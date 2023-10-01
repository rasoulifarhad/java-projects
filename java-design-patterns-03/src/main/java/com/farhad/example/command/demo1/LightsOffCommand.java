package com.farhad.example.command.demo1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LightsOffCommand implements Command{

    private Light light;

    @Override
    public void execute() {
        light.switchOff();
    }


}
