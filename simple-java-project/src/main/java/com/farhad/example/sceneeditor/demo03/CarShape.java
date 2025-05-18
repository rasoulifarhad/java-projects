package com.farhad.example.sceneeditor.demo03;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class CarShape extends SelectableShape {

    private int x;
    private int y;
    private int width;

    public CarShape(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }


    public void draw(Graphics2D g2) {
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6,
                width - 1, width / 6);
        Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / 6, y + width / 3,
                width / 6, width / 6);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3,
                y + width / 3,
                width / 6, width / 6);

        // The bottom of the front windshield
        Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);
        // The front of the roof
        Point2D.Double r2 = new Point2D.Double(x + width / 3, y);
        // The rear of the roof
        Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);
        // The bottom of the rear windshield
        Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

        g2.draw(body);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public boolean contains(Point2D p) {
        return x <= p.getX() && p.getY() <= (x + width)
                && y <= p.getY() && p.getY() <= (y + width / 2);
    }

    
}
