package com.farhad.example.dispatch.displayport;

public class Client {
    
    public static void main(String[] args) {
        Port port = new PrinterPort();
        Displayable oval = new Oval();
        oval.displayOn(port);

        port = new DisplayPort();
        oval.displayOn(port);
    }
}
