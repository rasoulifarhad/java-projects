package com.farhad.example.bridge.standard_approach.paintshop;

public class Truck extends Vehicle {

    
    public Truck(PaintShop paintWork, PaintShop polishWork) {
        super(paintWork, polishWork);

    }

    @Override
    public void applyChange() {
        System.out.println("Trunck work going to start");
        paintWork.doWork();
        polishWork.doWork();        
    }
    
}
