package com.farhad.example.designpatterns.templatemethod.better;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Bus implements Vehicle {

    private final VehicleColor color;
}
