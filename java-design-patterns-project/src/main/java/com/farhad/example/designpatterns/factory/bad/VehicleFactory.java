package com.farhad.example.designpatterns.factory.bad;

public class VehicleFactory {
    
    // The use of if conditions to check type normally leads to code duplication
    // Adding a new type implies having to remember that we have to add a new if condition
    // We have to throw IllegalArgumentException, as it’s possible that we forgot to handle a new type
    public static Vehicle instanceOfType(VehicleType type, VehicleColor color) {
        if (type == VehicleType.CAR) {
            return new Car(color);
        } else if (type == VehicleType.BUS) {
            return new Bus(color);
        } else if ( type == VehicleType.TRUNK) {
            return new Trunk(color);
        }
        throw new IllegalArgumentException("No support for type" + type);
    }

}
