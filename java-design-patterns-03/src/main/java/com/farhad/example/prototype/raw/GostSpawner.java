package com.farhad.example.prototype.raw;

public class GostSpawner extends Spawner {

    @Override
    public Monster spawnMonster() {
        return new Gost(100, 60);
    }

}
