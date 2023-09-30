package com.farhad.example.bridge.standard_approach.paintshop;

public class Car extends Vehicle{

    public Car(PaintShop paintWork, PaintShop polishWork) {
        super(paintWork, polishWork);
    }

    @Override
    public void applyChange() {
        System.out.println("Car work going to start");
        paintWork.doWork();
        polishWork.doWork();        
    }
    
}
