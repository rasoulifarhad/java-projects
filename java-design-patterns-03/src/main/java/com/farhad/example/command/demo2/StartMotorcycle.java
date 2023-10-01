package com.farhad.example.command.demo2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StartMotorcycle implements Command {

    private Vehicle vehicle;

    @Override
    public void execute() {
        vehicle.start();
    }

    @Override
    public void revert() {
        vehicle.stop();
    }
    
}
