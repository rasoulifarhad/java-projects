package com.farhad.example.sceneeditor.demo02;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class HouseShape extends SelectableShape {

    public HouseShape() {
        super();
    }

    @Override
    public void draw(Graphics2D g2) {
    }

    @Override
    public void translate(int dx, int dy) {
    }

    @Override
    public boolean contains(Point2D aPoint) {
        return false;
    }

    @Override
    public void drawSelection(Graphics2D g2) {
    }

}
