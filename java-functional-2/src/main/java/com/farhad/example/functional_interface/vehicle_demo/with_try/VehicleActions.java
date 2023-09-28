package com.farhad.example.functional_interface.vehicle_demo.with_try;

import java.util.function.Function;

import com.farhad.example.functional_interface.vehicle_demo.with_try.toolkit.Try;

public class VehicleActions {

    static final Function<Distance,Function<Vehicle, Try<Vehicle>>> MOVE_FORWARD = 
                        distance -> vehicle -> vehicle.moveForward(distance);

    static final Function<Distance,Function<Vehicle, Try<Vehicle>>> MOVE_LEFT = 
                        distance -> vehicle -> vehicle.moveLeft(distance);
    
    static final Function<Distance,Function<Vehicle, Try<Vehicle>>> MOVE_RIGHT = 
                        distance -> vehicle -> vehicle.moveRight(distance);

    static final Function<Vehicle, Try<Vehicle>> STOP = Vehicle::stop;

    static final Function<Vehicle, Try<Vehicle>> START = Vehicle::wakeUp;

   
}
