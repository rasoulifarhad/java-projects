package com.farhad.example.sceneeditor.demo05;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class HouseShape extends CompoundShape {


    public HouseShape(int x, int y, int width) {
        Rectangle2D.Double base = new Rectangle2D.Double(x, y + width, width, width);
        Point2D.Double roofLeftBottom = new Point2D.Double(x, y + width);
        Point2D.Double roofTop = new Point2D.Double(x + width / 2, y);
        Point2D.Double roofRightBottom = new Point2D.Double(x + width, y + width);
        Line2D.Double roofLeft = new Line2D.Double(roofLeftBottom, roofTop);
        Line2D.Double roofRight = new Line2D.Double(roofTop, roofRightBottom);

        add(base);
        add(roofLeft);
        add(roofRight);
    }


}
