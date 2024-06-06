package com.farhad.example.prototype.good;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Spawner {

    private final Monster prototype;

    public  Monster spawnMonster(){
        try {
            return prototype.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
