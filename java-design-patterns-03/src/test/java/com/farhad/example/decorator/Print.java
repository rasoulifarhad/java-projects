package com.farhad.example.decorator;

import lombok.Getter;

public class Print extends ImageDecorator {

    @Getter
    private final double printWidth;
    @Getter
    private final double printHeight; 

    public Print(double printWidth, double printHeight , PhotoImage target) {
        super(target);
        this.printWidth = printWidth;
        this.printHeight = printHeight;
    }

    @Override
    public String getDescription() {
        return target.getDescription() + " " + 
            String.format("(%4.1f  x  %4.1f  in)", getPrintWidth(), getPrintHeight());
    }

    

}
