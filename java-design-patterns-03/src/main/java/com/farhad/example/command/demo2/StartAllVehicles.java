package com.farhad.example.command.demo2;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StartAllVehicles implements Command{
    
    private List<Vehicle> vehicles;

    @Override
    public void execute() {
        vehicles.forEach(Vehicle::start);
    }

    @Override
    public void revert() {
        vehicles.forEach(Vehicle::stop);
    }
    

}
