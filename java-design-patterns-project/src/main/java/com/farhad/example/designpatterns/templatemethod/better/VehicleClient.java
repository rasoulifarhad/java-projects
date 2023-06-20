package com.farhad.example.designpatterns.templatemethod.better;

public class VehicleClient {
    public static void main(String[] args) {
        System.out.println();
        Vehicle redCar = VehicleType.CAR.factory.apply(VehicleColor.RED);
        redCar.start(nil -> {
            System.out.println("PreCheck01: checke if car ......");
            System.out.println("PreCheck02: checke if car ......");
            System.out.println("PreCheck03: checke if car ......");
        });
        System.out.println();
        Vehicle blackBus = VehicleType.BUS.factory.apply(VehicleColor.BLACK);
        blackBus.start(nil -> {
            System.out.println("PreCheck01: Check if every new passenger has paid for their tickets") ;
            System.out.println("PreCheck02: Check if every passenger is seated") ;
        });

        System.out.println();
        Vehicle whiteTrunk = VehicleType.TRUNK.factory.apply(VehicleColor.WHITE);
        whiteTrunk.start(nil -> {
            System.out.println("PreCheck01: checke if trunk ......");
            System.out.println("PreCheck02: checke if trunk ......");
            System.out.println("PreCheck03: checke if trunk ......");
            System.out.println("PreCheck04: checke if trunk ......");
        });
    }
}
