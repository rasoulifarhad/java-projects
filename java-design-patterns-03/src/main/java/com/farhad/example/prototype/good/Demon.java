package com.farhad.example.prototype.good;

public class Demon extends Monster {

    @Override
    protected Monster clone() throws CloneNotSupportedException {
        return new Demon();
    }

}
