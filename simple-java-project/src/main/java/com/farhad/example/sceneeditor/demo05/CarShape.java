package com.farhad.example.sceneeditor.demo05;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class CarShape extends CompoundShape {

    public CarShape(int x, int y, int width) {
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

        add(body);
        add(frontTire);
        add(rearTire);
        add(frontWindshield);
        add(roofTop);
        add(rearWindshield);
    }


    
}
