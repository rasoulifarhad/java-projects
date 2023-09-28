package com.farhad.example.functional_interface.vehicle_demo.functional;

import static com.farhad.example.functional_interface.vehicle_demo.functional.Distance.meter;
import static com.farhad.example.functional_interface.vehicle_demo.functional.VehicleActions.MOVE_FORWARD;
import static com.farhad.example.functional_interface.vehicle_demo.functional.VehicleActions.MOVE_LEFT;
import static com.farhad.example.functional_interface.vehicle_demo.functional.VehicleActions.MOVE_RIGHT;
import static com.farhad.example.functional_interface.vehicle_demo.functional.VehicleActions.RIDE;
import static com.farhad.example.functional_interface.vehicle_demo.functional.VehicleActions.START;
import static com.farhad.example.functional_interface.vehicle_demo.functional.VehicleActions.STOP;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class App {
    
    public static void main(String[] args) {
        
        Vehicle vehicle = new Vehicle.Default();
        final UnaryOperator<Vehicle> move3MeterToLeft = MOVE_LEFT.apply(meter(3));
        final UnaryOperator<Vehicle> move10MeterToRight = MOVE_RIGHT.apply(meter(10));
        final UnaryOperator<Vehicle> move13MeterForward = MOVE_FORWARD.apply(meter(13));

        System.out.println(
            START
                .andThen(move3MeterToLeft)
                .andThen(move10MeterToRight)
                .andThen(move13MeterForward)
                .andThen(STOP)
            .apply(vehicle)
                .currentPosition());

        UnaryOperator<Vehicle> allMoves = Stream.of(move3MeterToLeft, move10MeterToRight, move13MeterForward)
            .reduce(
                UnaryOperator.identity(), 
                (first, second) -> v -> second.apply(first.apply(v)));
        System.out.println(
            STOP.apply(allMoves.apply(START.apply(vehicle))).currentPosition());

        UnaryOperator<Vehicle> allMoves2 = Stream.of(move3MeterToLeft, move10MeterToRight, move13MeterForward)
            .reduce(
                UnaryOperator.identity(), 
                (first, second) -> v -> second.apply(first.apply(v)));
        System.out.println(
            RIDE.apply(allMoves2).apply(vehicle).currentPosition());

    }
}
