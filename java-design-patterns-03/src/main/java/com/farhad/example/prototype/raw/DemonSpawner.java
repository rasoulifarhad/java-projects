package com.farhad.example.prototype.raw;

public class DemonSpawner extends Spawner {

    @Override
    public Monster spawnMonster() {
        return new Demon();
    }

}
