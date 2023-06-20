package com.farhad.example.designpatterns.templatemethod.oldway;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Data
public class Bus extends AbstractVehicle {

    private final VehicleColor color;

    @Override
    public void preStartCheck() {
        System.out.println("PreCheck01: Check if every new passenger has paid for their tickets") ;
        System.out.println("PreCheck02: Check if every passenger is seated") ;
    }
    
}
