package com.farhad.example.prototype.good;

public class Sorcerer extends Monster {

    @Override
    protected Monster clone() throws CloneNotSupportedException {
        return new Sorcerer();
    }

}
