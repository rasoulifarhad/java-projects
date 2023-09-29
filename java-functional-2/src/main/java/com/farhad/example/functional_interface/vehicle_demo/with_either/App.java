package com.farhad.example.functional_interface.vehicle_demo.with_either;

import com.farhad.example.functional_interface.vehicle_demo.with_either.toolkit.Either;
import com.farhad.example.functional_interface.vehicle_demo.with_either.toolkit.TryWithError;

public class App {
    
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle.Default();
        final Either<RuntimeException, Vehicle> vehicleMoveResult = 
            TryWithError.to(Vehicle::wakeUp)
                .andThen(v -> v.moveLeft(Distance.FIVE_METER) )
                .andThen(v -> v.moveForward(Distance.THREE_METER) )
                .andThen(v -> v.moveRight(Distance.THREE_METER))
                .andThen(Vehicle::stop)
                .execte(vehicle);
        System.out.println(vehicleMoveResult);

        Vehicle unableToMoveForwardVehicle = new Vehicle.UnableToMoveForward();
        final Either<RuntimeException, Vehicle> unableToMoveForwardVehicleMoveResult = 
            TryWithError.to(Vehicle::wakeUp)
                .andThen(v -> v.moveLeft(Distance.FIVE_METER) )
                .andThen(v -> v.moveForward(Distance.THREE_METER) )
                .andThen(v -> v.moveRight(Distance.THREE_METER))
                .andThen(Vehicle::stop)
                .execte(unableToMoveForwardVehicle);
        System.out.println(unableToMoveForwardVehicleMoveResult);

    }
}
