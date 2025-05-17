package com.farhad.example.carmover;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class CarComponent extends JComponent {

    private CarShape car;
    private Point mousePoint;

    public CarComponent() {
        car = new CarShape(20, 20, 50);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                mousePoint = e.getPoint();
                if(!car.contains(mousePoint)){
                    mousePoint = null;
                }
            }
            
        });
        addMouseMotionListener(new MouseMotionAdapter(){

            @Override
            public void mouseDragged(MouseEvent e) {
                if(mousePoint == null) return;
                Point lastMousePoint = mousePoint;
                mousePoint = e.getPoint();
                double dx = mousePoint.getX() - lastMousePoint.getX();
                double dy = mousePoint.getY() - lastMousePoint.getY();
                car.translate((int)dx, (int)dy);
                repaint();
            }
            
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        car.draw(g2);
    }

    
    
}
