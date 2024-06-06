package com.farhad.example.prototype.good;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Gost extends Monster {

    private int health;
    private int speed;

    @Override
    protected Monster clone() throws CloneNotSupportedException {
        return new Gost(health, speed);
    }
}
