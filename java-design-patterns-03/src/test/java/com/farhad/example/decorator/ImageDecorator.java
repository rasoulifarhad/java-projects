package com.farhad.example.decorator;

public abstract class ImageDecorator extends PhotoImage {

    final protected PhotoImage target;

    public ImageDecorator(PhotoImage target) {
        this.target = target;
    }

    @Override
    public String getDescription() {
        return target.getDescription();
    }

    @Override
    public String toString() {
        return getDescription();
    }

   
}
