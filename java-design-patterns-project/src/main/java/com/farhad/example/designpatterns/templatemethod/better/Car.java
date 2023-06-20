package com.farhad.example.designpatterns.templatemethod.better;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Car implements Vehicle {

    private final VehicleColor color;
}
