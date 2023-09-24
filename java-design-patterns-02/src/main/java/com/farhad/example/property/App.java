package com.farhad.example.property;

import static com.farhad.example.property.Stats.AGILITY;
import static com.farhad.example.property.Stats.ARMOR;
import static com.farhad.example.property.Stats.ATACK_POWER;
import static com.farhad.example.property.Stats.ENERGY;
import static com.farhad.example.property.Stats.INJTELLECT;
import static com.farhad.example.property.Stats.RAGE;
import static com.farhad.example.property.Stats.SPIRIT;
import static com.farhad.example.property.Stats.STRENGTH;

import com.farhad.example.property.Character.Type;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    
    public static void main(String[] args) {
        
        Prototype characterPrototype = new Character();
        characterPrototype.set(STRENGTH, 10);
        characterPrototype.set(AGILITY, 10);
        characterPrototype.set(ARMOR, 10);
        characterPrototype.set(ATACK_POWER, 10);

        Character magePrototype = new Character(Type.MAGE, characterPrototype);
        magePrototype.set(INJTELLECT, 15);
        magePrototype.set(SPIRIT, 10);

        Character warriorPrototype = new Character(Type.WARRIOR, characterPrototype);
        warriorPrototype.set(RAGE, 15);
        warriorPrototype.set(ARMOR, 15); // boost default armor for warrior

        Character roguePrototype = new Character(Type.ROUGE, characterPrototype);
        roguePrototype.set(ENERGY, 15);
        roguePrototype.set(AGILITY, 15); // boost default agility for rogue

        Character mag = new Character("Player_1", magePrototype);
        mag.set(ARMOR, 8);
        log.info(mag.toString());

        Character warrior = new Character("Player_2", warriorPrototype);
        log.info(warrior.toString());

        Character rogue = new Character("Player_3", roguePrototype);
        log.info(rogue.toString());

        Character rogueDouble = new Character("Player_4", rogue);
        rogueDouble.set(ATACK_POWER, 12);
        log.info(rogueDouble.toString());

    }
}
