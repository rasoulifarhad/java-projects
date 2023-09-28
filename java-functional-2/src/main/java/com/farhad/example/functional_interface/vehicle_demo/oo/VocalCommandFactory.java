package com.farhad.example.functional_interface.vehicle_demo.oo;

import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.MoveForwardCommand;
import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.MoveLeftCommand;
import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.MoveRightCommand;
import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.StopCommand;

public class VocalCommandFactory {
    
    public MoveForwardCommand moveForward(Vehicle vehicle, Distance distance) {
        return new MoveForwardCommand(vehicle, distance);
    }
    public MoveLeftCommand moveLeft(Vehicle vehicle, Distance distance) {
        return new MoveLeftCommand(vehicle, distance);
    }
    public MoveRightCommand moveRight(Vehicle vehicle, Distance distance) {
        return new MoveRightCommand(vehicle, distance);
    }
    public StopCommand stop(Vehicle vehicle) {
        return new StopCommand(vehicle);
    }
}
