package com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand;

import com.farhad.example.functional_interface.vehicle_demo.oo.Vehicle;

public class StopCommand extends AbstractVehicleCommand {

    
    public StopCommand(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void execute() {
        getVehicle().stop();
    }

}
