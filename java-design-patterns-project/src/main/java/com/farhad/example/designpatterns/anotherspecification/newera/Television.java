package com.farhad.example.designpatterns.anotherspecification.newera;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Television extends Product {
   
    private Resolution resolution;

    private float screenSize ;

    public Television(double price, int units, Resolution resolution, float screenSize) {
        super(price, units);
        this.resolution = resolution;
        this.screenSize = screenSize;
    }
    
}
