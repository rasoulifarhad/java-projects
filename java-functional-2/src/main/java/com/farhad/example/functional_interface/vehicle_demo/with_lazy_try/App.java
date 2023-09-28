package com.farhad.example.functional_interface.vehicle_demo.with_lazy_try;

import static com.farhad.example.functional_interface.vehicle_demo.with_lazy_try.Distance.meter;

import com.farhad.example.functional_interface.vehicle_demo.with_lazy_try.toolkit.LazyTry;

public class App {
    
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle.Default();

        System.out.println(
            LazyTry.to(Vehicle::wakeUp)
                .andThen(v -> v.moveLeft(meter(5)))
                .andThen(v -> v.moveForward(meter(3)))
                .andThen(v -> v.moveRight(meter(7)))
                .andThen(Vehicle::stop)
                .onError(ex -> System.out.printf("Simple try example: exception caught: %s  \n", ex.getMessage()))
                .execute(vehicle).currentPosition());

    }
}
