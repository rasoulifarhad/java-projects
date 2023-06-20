package com.farhad.example.designpatterns.templatemethod.oldway;

public class VehicleFactory {
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
