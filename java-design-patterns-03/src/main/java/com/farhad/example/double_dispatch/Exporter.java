package com.farhad.example.double_dispatch;

public class Exporter {
    
    public void export(Shape shape) {
        System.out.println("Exporting shape");
    }

    public void export(Dot dot) {
        System.out.println("Exporting dot");
    }

    public void export(Circle circle) {
        System.out.println("Exporting circle");
    }

    public void export(Rectangle rectangle) {
        System.out.println("Exporting rectangle");
    }

    public void export(CompoundGraphic graphic) {
        System.out.println("Exporting compoundGraphic");
    }

}
