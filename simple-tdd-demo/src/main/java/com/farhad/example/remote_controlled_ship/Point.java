package com.farhad.example.remote_controlled_ship;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Point {

    private int x;
    private int y;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
