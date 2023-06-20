package com.farhad.example.designpatterns.templatemethod.oldway;

public class VehicleClient {
    public static void main(String[] args) {
        Vehicle redCar = VehicleFactory.instanceOfType(VehicleType.CAR, VehicleColor.RED);
        redCar.start();
        
        Vehicle blackBus = VehicleFactory.instanceOfType(VehicleType.BUS, VehicleColor.BLACK);
        blackBus.start();

        Vehicle whiteTrunk = VehicleFactory.instanceOfType(VehicleType.TRUNK, VehicleColor.WHITE);
        whiteTrunk.start();
    }
}
