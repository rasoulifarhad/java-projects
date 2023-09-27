package com.farhad.example.double_dispatch;

public class Dot extends Shape {
    
    private int x, y;

    @Override
    public void draw() {
        System.out.println("Drawing dot.");
    }

    @Override
    public void accept(Exporter exporter) {
        exporter.export(this);
    }

    
}
