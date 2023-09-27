package com.farhad.example.double_dispatch;

public class Shape implements Graphic {

    protected String id;

    @Override
    public void draw() {
        System.out.println("Drawing shap.");
    }
 
    public void accept(Exporter exporter) {
        exporter.export(this);
    }
}
