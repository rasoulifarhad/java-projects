package com.farhad.example.double_dispatch;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.export(new Circle());
    }

    public void export(Shape shape) {
        Exporter exporter = new Exporter();
        exporter.export(shape);
        System.out.println("==========================");

        Graphic graphic = new Dot();
        graphic.accept(exporter);

        graphic = new Circle();
        graphic.accept(exporter);

        graphic = new Rectangle();
        graphic.accept(exporter);
    }
}
