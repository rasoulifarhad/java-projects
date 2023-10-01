package com.farhad.example.command.demo2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccelerateMotorcycle implements Command {
    
    private Vehicle vehicle;

    @Override
    public void execute() {
        vehicle.accelerate();
    }

    @Override
    public void revert() {
        vehicle.decelerate();
    }
    

}
