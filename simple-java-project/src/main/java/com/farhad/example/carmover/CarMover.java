package com.farhad.example.carmover;

import javax.swing.JFrame;

public class CarMover {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new CarComponent());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
