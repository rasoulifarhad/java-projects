package com.farhad.example.designpatterns.templatemethod.better;

import java.util.function.Function;

public enum VehicleType {
    CAR(Car::new),
    BUS(Bus::new),
    TRUNK(Trunk::new);

    public final Function<VehicleColor, Vehicle> factory;

    VehicleType(Function<VehicleColor, Vehicle> factory) {
        this.factory = factory;
    }
}
