package com.farhad.example.sceneeditor.demo01;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class CarShape implements SceneShape {

    private boolean selected;

    public CarShape() {
        selected = false;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

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

    
}
