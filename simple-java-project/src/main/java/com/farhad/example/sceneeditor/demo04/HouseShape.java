package com.farhad.example.sceneeditor.demo04;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class HouseShape extends SelectableShape {

    private int x;
    private int y;
    private int width;

    public HouseShape(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    @Override
    public void draw(Graphics2D g2) {
        Rectangle2D.Double base = new Rectangle2D.Double(x, y + width, width, width);
        Point2D.Double roofLeftBottom = new Point2D.Double(x, y + width);
        Point2D.Double roofTop = new Point2D.Double(x + width / 2, y);
        Point2D.Double roofRightBottom = new Point2D.Double(x + width, y + width);
        Line2D.Double roofLeft = new Line2D.Double(roofLeftBottom, roofTop);
        Line2D.Double roofRight = new Line2D.Double(roofTop, roofRightBottom);

        g2.draw(base);
        g2.draw(roofLeft);
        g2.draw(roofRight);
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public boolean contains(Point2D aPoint) {
        return x <= aPoint.getX() && aPoint.getX() <= x + width 
                   && y <= aPoint.getY() && aPoint.getY() <= y + 2 * width;    
    }

}
