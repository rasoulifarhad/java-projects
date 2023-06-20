package com.farhad.example.designpatterns.templatemethod.oldway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Trunk extends AbstractVehicle {

    private final VehicleColor color;

    @Override
    public void preStartCheck() {
        System.out.println("PreCheck01: checke if trunk ......");
        System.out.println("PreCheck02: checke if trunk ......");
        System.out.println("PreCheck03: checke if trunk ......");
        System.out.println("PreCheck04: checke if trunk ......");
    }
    
}
