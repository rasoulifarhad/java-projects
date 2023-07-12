package com.farhad.example.dispatch.shapandpainter;

public class Client {
    
    public static void main(String[] args) {
        
        Shape triangle = new Triangle();
        Painter redPainter = new RedPainter();
        triangle.paint(redPainter);

        Painter greenPainter = new GreenPainter();
        triangle.paint(greenPainter);

        Shape square = new Square();
        square.paint(greenPainter);
    }
}
