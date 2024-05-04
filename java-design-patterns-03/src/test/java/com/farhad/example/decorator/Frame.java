package com.farhad.example.decorator;

public class Frame extends ImageDecorator {

    public Frame(PhotoImage target) {
        super(target);
    }

    @Override
    public String getDescription() {
        return target.getDescription() + " " + 
            String.format("(Frame)");
    }


}
