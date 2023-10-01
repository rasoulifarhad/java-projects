package com.farhad.example.command.demo2;

import java.util.Arrays;
import java.util.List;

public class App {
    
    public static void main(String[] args) {
        
        Vehicle motorcycle = new Motorcycle();

        StartMotorcycle startCommand = new StartMotorcycle(motorcycle);
        GhostRider ghostRider = new GhostRider(startCommand);
        ghostRider.takeAction();
    
        AccelerateMotorcycle accelerateCommand = new AccelerateMotorcycle(motorcycle);
        ghostRider.setCommand(accelerateCommand);
        ghostRider.takeAction();
        ghostRider.revertAction();
    
        Vehicle truck = new Truck();
        List<Vehicle> vehicles = Arrays.asList(motorcycle, truck);
        StartAllVehicles startAllVehicles = new StartAllVehicles(vehicles);
        startAllVehicles.execute();
        startAllVehicles.revert();        
    }
}
