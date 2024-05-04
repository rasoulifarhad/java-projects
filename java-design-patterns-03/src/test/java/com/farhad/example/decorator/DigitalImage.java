package com.farhad.example.decorator;

public class DigitalImage extends ImageDecorator {

    public DigitalImage(String title, String fileName, PhotoImage target) {
        super(target);
    }

}
