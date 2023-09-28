package com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand;

import com.farhad.example.functional_interface.vehicle_demo.oo.Vehicle;

public class StartCommand extends AbstractVehicleCommand {

    public StartCommand(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void execute() {
        getVehicle().wakeUp();
    }
    
}
