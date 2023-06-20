package com.farhad.example.designpatterns.factory.bad;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleClient {
    
    public static void main(String[] args) {
        Vehicle redCar = VehicleFactory.instanceOfType(VehicleType.CAR, VehicleColor.RED); 
    }
}
