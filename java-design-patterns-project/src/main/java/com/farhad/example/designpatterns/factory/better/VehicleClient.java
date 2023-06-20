package com.farhad.example.designpatterns.factory.better;

import static com.farhad.example.designpatterns.factory.better.VehicleType.BUS;
import static com.farhad.example.designpatterns.factory.better.VehicleType.CAR;
import static com.farhad.example.designpatterns.factory.better.VehicleType.TRUNK;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleClient {
    
    public static void main(String[] args) {
        Vehicle redCar = CAR.factory.apply(VehicleColor.REB);
        log.info("{}", redCar);

        Vehicle blackBus = BUS.factory.apply(VehicleColor.BLACK);
        log.info("{}", blackBus);

        Vehicle whiteTrunk = TRUNK.factory.apply(VehicleColor.WHITE);
        log.info("{}", whiteTrunk);

    }
}
