package com.farhad.example.designpatterns.templatemethod.oldway;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Data
public class Car extends AbstractVehicle {

    private final VehicleColor color;

    @Override
    public void preStartCheck() {
        System.out.println("PreCheck01: checke if car ......");
        System.out.println("PreCheck02: checke if car ......");
        System.out.println("PreCheck03: checke if car ......");
    }
    
}
