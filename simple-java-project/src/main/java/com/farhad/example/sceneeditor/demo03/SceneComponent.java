package com.farhad.example.sceneeditor.demo03;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JComponent;

public class SceneComponent extends JComponent {

    private List<SceneShape> shapes;
    private Point mousePoint;

    public SceneComponent() {

        shapes = new ArrayList<>();
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                mousePoint = e.getPoint();
                for (SceneShape shape : shapes) {
                    if(shape.contains(mousePoint)) {
                        shape.setSelected(!shape.isSelected());
                    }
                }
                repaint();
            }
            
        });
        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                Point lastMousePoint = mousePoint;
                mousePoint = e.getPoint();
                for (SceneShape shape : shapes) {
                    if(shape.isSelected()) {
                        double dx = mousePoint.getX() - lastMousePoint.getX();
                        double dy = mousePoint.getY() - lastMousePoint.getY();
                        shape.translate((int) dx, (int) dy);
                    }
                }
                repaint();
            }
            
        });
    }

    
    public void add(SceneShape shape) {
        shapes.add(shape);
        repaint();
    }

    public void removeSelected() {
        ListIterator<SceneShape> l =  shapes.listIterator();
        while (l.hasNext()) {
            SceneShape s = l.next();
            if (s.isSelected()) {
                l.remove();
            }
        }
        repaint();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for (SceneShape s : shapes) {
            s.draw(g2);
            if(s.isSelected()) {
                s.drawSelection(g2);
            }
        }
    }
}
