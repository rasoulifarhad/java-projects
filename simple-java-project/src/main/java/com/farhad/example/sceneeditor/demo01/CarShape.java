package com.farhad.example.sceneeditor.demo01;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class CarShape implements SceneShape {

    @Override
    public boolean contains(Point2D aPoint) {
        return false;
    }

    @Override
    public void draw(Graphics2D g2) {
    }

    @Override
    public void translate(int dx, int dy) {
    }

    @Override
    public void drawSelection(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawSelection'");
    }

    
}
