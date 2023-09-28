package com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand;

import com.farhad.example.functional_interface.vehicle_demo.oo.Distance;
import com.farhad.example.functional_interface.vehicle_demo.oo.Vehicle;

public class MoveForwardCommand extends AbstractVehicleCommand {

    private final Distance distance;

    public MoveForwardCommand(Vehicle vehicle, final Distance distance) {
        super(vehicle);
        this.distance = distance;
    }

    @Override
    public void execute() {
        getVehicle().moveForward(distance);
    }

}
