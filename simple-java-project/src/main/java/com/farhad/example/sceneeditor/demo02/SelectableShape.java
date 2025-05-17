package com.farhad.example.sceneeditor.demo02;

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

}
