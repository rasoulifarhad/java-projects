package com.farhad.example.double_dispatch;

public class Rectangle extends Shape {
  
    private int width, height;
    
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle.");
    }
    
    @Override
    public void accept(Exporter exporter) {
        exporter.export(this);
    }    
}
