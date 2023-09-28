package com.farhad.example.functional_interface.vehicle_demo.with_try;

import static com.farhad.example.functional_interface.vehicle_demo.with_try.VehicleActions.MOVE_FORWARD;
import static com.farhad.example.functional_interface.vehicle_demo.with_try.VehicleActions.MOVE_LEFT;
import static com.farhad.example.functional_interface.vehicle_demo.with_try.VehicleActions.MOVE_RIGHT;
import static com.farhad.example.functional_interface.vehicle_demo.with_try.VehicleActions.START;
import static com.farhad.example.functional_interface.vehicle_demo.with_try.VehicleActions.STOP;

import com.farhad.example.functional_interface.vehicle_demo.with_try.toolkit.Try;

public class App {
    
    public static void main(String[] args) {
        final Try<Vehicle> firstTry = Try.<Vehicle>of(Vehicle.Default::new)
                .flatMap(START)
                .flatMap(MOVE_FORWARD.apply(Distance.THREE_METER))
                .flatMap(MOVE_LEFT.apply(Distance.FIVE_METER))
                .flatMap(MOVE_RIGHT.apply(Distance.TEN_METER))
                .flatMap(STOP);
        System.out.println("Vehicle successful moved: " + firstTry.isSuccess());

        System.out.println("....");

        final Try<Vehicle> secondTry = Try.<Vehicle>of(Vehicle.UnableToMoveForward::new)
                .flatMap(START)
                .flatMap(MOVE_FORWARD.apply(Distance.THREE_METER))
                .flatMap(MOVE_LEFT.apply(Distance.FIVE_METER))
                .flatMap(MOVE_RIGHT.apply(Distance.TEN_METER))
                .flatMap(STOP);
        System.out.println("Vehicle successful moved: " + secondTry.isSuccess());    }
}
