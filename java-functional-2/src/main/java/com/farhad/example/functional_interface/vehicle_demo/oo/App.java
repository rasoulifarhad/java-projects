package com.farhad.example.functional_interface.vehicle_demo.oo;

import static com.farhad.example.functional_interface.vehicle_demo.oo.Distance.inch;
import static com.farhad.example.functional_interface.vehicle_demo.oo.Distance.meter;

import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.MoveForwardCommand;
import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.MoveLeftCommand;
import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.MoveRightCommand;

public class App {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle.Default();
        new VehicleRide(
            new MoveForwardCommand(vehicle, Distance.ONE_METER),
            new MoveLeftCommand(vehicle, inch(2)),
            new MoveRightCommand(vehicle, meter(3))
        ).startRide();
    }
}
