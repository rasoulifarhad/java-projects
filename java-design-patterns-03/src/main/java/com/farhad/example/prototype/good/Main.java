package com.farhad.example.prototype.good;

public class Main {

    public static void main(String[] args) {
        
        Monster gostPrototype = new Gost(100, 60);

        Spawner gostSpawner = new Spawner(gostPrototype);

        gostSpawner.spawnMonster();

    }
}
