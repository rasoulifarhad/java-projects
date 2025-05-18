package com.farhad.example.sceneeditor.demo05;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public abstract class CompoundShape extends SelectableShape {

    private GeneralPath path;
   
    public CompoundShape() {
        path = new GeneralPath();
    }

    protected void add(Shape shape) {
        path.append(shape, false);
    }

    @Override
    public void translate(int dx, int dy) {
        path.transform(AffineTransform.getTranslateInstance(dx, dy));
    }

    @Override
    public boolean contains(Point2D aPoint) {
        return path.contains(aPoint);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.draw(path);
    }

}
