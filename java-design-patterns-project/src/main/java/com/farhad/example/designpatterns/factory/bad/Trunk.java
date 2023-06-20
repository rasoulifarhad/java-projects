package com.farhad.example.designpatterns.factory.bad;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Trunk implements Vehicle {
    private final VehicleColor color;
    
}
