package com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand;

import com.farhad.example.functional_interface.vehicle_demo.oo.Distance;
import com.farhad.example.functional_interface.vehicle_demo.oo.Vehicle;


public class MoveLeftCommand extends AbstractVehicleCommand {

    private final Distance distance;

    public MoveLeftCommand(Vehicle vehicle, final Distance distance) {
        super(vehicle);
        this.distance = distance;
    }

    @Override
    public void execute() {
        getVehicle().moveLeft(distance);

    }

}
