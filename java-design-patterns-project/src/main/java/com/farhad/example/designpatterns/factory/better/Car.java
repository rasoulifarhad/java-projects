package com.farhad.example.designpatterns.factory.better;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Car implements Vehicle {
    private final VehicleColor color;
    
}
