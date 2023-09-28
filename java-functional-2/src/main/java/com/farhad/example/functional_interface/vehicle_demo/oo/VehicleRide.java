package com.farhad.example.functional_interface.vehicle_demo.oo;

import java.util.Arrays;
import java.util.List;

import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.AbstractVehicleCommand;

public class VehicleRide extends AbstractRideTemplate {

    List<AbstractVehicleCommand> commands;

    
    public VehicleRide(AbstractVehicleCommand... commands) {
        this.commands = Arrays.asList(commands);
    }

    @Override
    void mainRide() {
        try {
            commands.stream()
                .forEach(AbstractVehicleCommand::execute);
        } catch (VehicleException e) {
            System.out.printf("Exception caught during vehicle ride: %s. Last known cart position is: %s \n",
                        e.getMessage(), 
                        vehicle().currentPosition());        
        }
    }

    @Override
    Vehicle vehicle() {
        return commands.get(0).getVehicle();
    }
    
}
