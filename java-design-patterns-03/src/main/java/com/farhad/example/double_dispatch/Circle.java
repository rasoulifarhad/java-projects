package com.farhad.example.double_dispatch;

public class Circle extends Dot {
    
    private double radius;

    @Override
    public void draw() {
        System.out.println("Drawing circle.");
    }

    @Override
    public void accept(Exporter exporter) {
        exporter.export(this);
    }

    
}
