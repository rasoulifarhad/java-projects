package com.farhad.example.sceneeditor.demo05;

import java.awt.Graphics2D;

public abstract class SelectableShape implements SceneShape {

    private boolean selected;
   
    public SelectableShape() {
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

    public abstract void draw(Graphics2D g2);

    @Override
    public void drawSelection(Graphics2D g2) {
        translate(1, 1);        
        draw(g2);
        translate(1, 1);
        draw(g2);
        translate(-2, -2);
    }

    

}
