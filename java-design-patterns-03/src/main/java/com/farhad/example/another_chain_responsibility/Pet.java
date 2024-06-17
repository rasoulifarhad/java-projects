package com.farhad.example.another_chain_responsibility;




import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Pet {
    protected final Pet nextPet;

    public String handleTrap(Bait bait) {
        throw new RuntimeException();
    }

}
