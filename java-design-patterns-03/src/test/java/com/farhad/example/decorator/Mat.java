package com.farhad.example.decorator;

import lombok.Getter;

public class Mat extends ImageDecorator {

    @Getter
    private String mat;


    public Mat(String mat, PhotoImage target) {
        super(target);
        this.mat = mat;
    }


    @Override
    public String getDescription() {
        return target.getDescription() + " " + 
            String.format("(%s)", getMat());
    }



}
