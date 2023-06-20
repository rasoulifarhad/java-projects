package com.farhad.example.designpatterns.factory.bad;

public interface Vehicle {
    
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
