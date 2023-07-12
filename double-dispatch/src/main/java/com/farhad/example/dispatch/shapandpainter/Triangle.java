package com.farhad.example.dispatch.shapandpainter;

public class Triangle implements Shape {

    @Override
    public void paint(Painter painter) {
        painter.paint(this);
    }

}
