package com.farhad.example.another_chain_responsibility;

public class Cat extends Pet{

    public Cat(Pet nextPet) {
        super(nextPet);
    }

    @Override
    public String handleTrap(Bait bait) {
        if(bait == Bait.SAUSAGE){
            return "purring cat";
        }
        return nextPet.handleTrap(bait);
    }

    
}
