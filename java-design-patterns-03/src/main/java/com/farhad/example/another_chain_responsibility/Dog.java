package com.farhad.example.another_chain_responsibility;

public class Dog extends Pet{

    public Dog(Pet nextPet) {
        super(nextPet);
    }

    @Override
    public String handleTrap(Bait bait) {
        return "fat, sleeping dog";
    }

    

}
