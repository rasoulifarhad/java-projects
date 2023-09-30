package com.farhad.example.bridge.standard_approach.paintshop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Vehicle {
    
    protected PaintShop paintWork;
    protected PaintShop polishWork;;


    public abstract void applyChange();
}
