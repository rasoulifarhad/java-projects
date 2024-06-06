package com.farhad.example.prototype.raw;

public class SorcererSpawner extends Spawner{

    @Override
    public Monster spawnMonster() {
        return new Sorcerer();
    }

}
