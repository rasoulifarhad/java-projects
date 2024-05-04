package com.farhad.example.decorator;

import lombok.Getter;

public class Mat extends ImageDecorator {

    @Getter
    private String color;


    public Mat(String color, PhotoImage target) {
        super(target);
        this.color = color;
    }


    @Override
    public String getDescription() {
        return target.getDescription() + " " + 
            String.format(", Matted(%s)", getColor());
    }



}
