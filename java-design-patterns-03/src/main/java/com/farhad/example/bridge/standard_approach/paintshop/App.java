package com.farhad.example.bridge.standard_approach.paintshop;

public class App {
    
    public static void main(String[] args) {
        
        Vehicle vehicle1= new Truck(new PaintWork(), new PolishWork());
        vehicle1.applyChange();
        Vehicle vehicle2= new Car(new PaintWork(), new PolishWork());
        vehicle2.applyChange();        
    }
}
