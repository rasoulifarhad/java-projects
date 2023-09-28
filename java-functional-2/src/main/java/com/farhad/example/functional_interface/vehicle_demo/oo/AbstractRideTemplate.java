package com.farhad.example.functional_interface.vehicle_demo.oo;

import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.StartCommand;
import com.farhad.example.functional_interface.vehicle_demo.oo.vocalCommand.StopCommand;

public abstract class AbstractRideTemplate {
    
    abstract void mainRide();
    abstract Vehicle vehicle();

    void startRide() {
        beforRide();
        mainRide();
        afterRide();
    }

    private void afterRide() {
        new StopCommand(vehicle()).execute();
    }

    private void beforRide() {
        new StartCommand(vehicle()).execute();
    }
}
