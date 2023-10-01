package com.farhad.example.command.demo1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LightsOnCommand implements Command{

    private Light light;

    @Override
    public void execute() {
        light.switchOn();
    }

}
