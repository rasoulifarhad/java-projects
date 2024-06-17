package com.farhad.example.another_chain_responsibility;

public class Hamster extends Pet{

    public Hamster(Pet nextPet) {
        super(nextPet);
    }

    @Override
    public String handleTrap(Bait bait) {
        if(bait == Bait.POPCORN) {
            return "Happy hamster";
        }
        return nextPet.handleTrap(bait);
    }

    
}
